// 실행 명령어 node ./index.js
// postman 사용법 나와있는 블로그 https://rwd337.tistory.com/173

const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

// req 객체가 지금 들어오는 요청의 경로를 가지고 있음
const server = http.createServer((req, res) => {
    if (req.url === '/'){
        res.statusCode = 200;
        res.setHeader('Content-Type', 'text/plain');
        res.end('Hello Chris!!\n');
    }else if (req.url === '/users'){
        const users = [
            {name: 'Alice'},
            {name: 'Beck'}
        ]
        res.statusCode = 200;
        // json으로 응답할 때 application/json 으로 지정해주어야 한다.
        res.setHeader('Content-Type', 'application/json');
        // end로 응답할 때는 항상 문자열으로 해주어야 한다. 그래서 JSON.stringify 함수로 users 객체를 문자열화
        res.end(JSON.stringify(users)); 
    }
});

server.listen(port, hostname, () => {
    console.log('Server running at http://${hostname}:${port}')
});