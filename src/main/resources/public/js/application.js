/**
 * AngularJS frontend logic.
 *
 * Since this is so small, we do not separate services, etc. into other files.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */

var demoApp = angular.module('messageBoard', [
    'ngResource',
    'pascalprecht.translate',
    'ui.bootstrap'
]);

// Create resource for RESTful endpoint.
demoApp.factory('Entry', function ($resource) {
    return $resource('rest/text/:id');
});

// I18N
demoApp.config(['$translateProvider', function ($translateProvider) {
    $translateProvider.useStaticFilesLoader({
        prefix: 'i18n/messages_',
        suffix: '.json'
    });
    $translateProvider.preferredLanguage('en');
}]);


demoApp.controller('LanguageCtrl', function ($scope, $translate) {
    // Available languages
    $scope.items = [
        'de',
        'en'
    ];

    $scope.use = function (lang) {
        $translate.use(lang);
    }
});

demoApp.controller('DemoCtrl', function ($scope, Entry, $translate) {
    function load() {
        Entry.query(function (data) {
            $scope.texts = data;
        });
    }

    $scope.submit = function () {
        var input = $scope.input;
        if (input == '') {
            return;
        }

        // Send raw data to the endpoint.
        Entry.save(input, function (data) {
            var text = {
                "text": input,
                "id": data
            };
            $scope.texts.push(text);
            $scope.input = '';
        });
    };

    // Initial loading.
    load();
});