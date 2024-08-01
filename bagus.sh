i#!/bin/bash

# Navigate to the Katalon Studio directory
cd /Applications/Katalon\ Studio\ Arm64.app/Contents/MacOS/

# Run the Katalon command


./katalon -noSplash -runMode=console -projectPath="/Users/bagustyo/git/katalon_test/shopping-cart-tests.prj" -retry=0 -testSuitePath="Test Suites/CAT/200_01_SAVE_TO_TXT" -browserType="Chrome" -executionProfile="default" -apiKey="c6fff483-82ff-4e00-9c39-5875551e6abe" -orgID=1541978 -testOpsProjectId=1513473 --config -proxy.auth.option=NO_PROXY -proxy.system.option=NO_PROXY -proxy.system.applyToDesiredCapabilities=true -webui.autoUpdateDrivers=true
