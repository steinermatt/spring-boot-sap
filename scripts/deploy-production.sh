#!/usr/bin/env bash
#
# Deploy version to production with a hot-update
# @author Michael Lesniak (mlesniak@micromata.de)
#
# neo.sh from the SDK must be on path

set -e

mvn -P production clean package
neo.sh hot-update config.properties

