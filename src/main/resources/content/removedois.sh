#!/bin/bash



dois="$(curl --user DEV.FIT:gofair https://mds.test.datacite.org/doi 2>/dev/null)"
for doi in $dois
do

    echo "Removing DOI: "$doi
    result="$(curl  -X DELETE -H "Content-Type: text/plain;charset=UTF-8" --user DEV.FIT:gofair https://mds.test.datacite.org/doi/$doi 2>/dev/null)"
    echo $result


done

