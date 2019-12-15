// 실행 명령어 node ./index.js

const fs = require('fs')

const callback = (err, file) => {
    console.log(file)
}

fs.readFile('test.txt',{
    encoding:'utf8'
}, callback)

