set APP="TicTacToe"

#Deploy new version
bin/clean
bin/package

test -f /tmp/%APP% && rm -r /tmp/%APP%

cp -r build/install/%APP% /tmp

#Run application
/tmp/%APP%/bin/%APP%

