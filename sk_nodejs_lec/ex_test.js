// node를 설치하면 npm도 자동으로 설치된다.
// 아래 명령어로 어딘가에 저장되어있는 express 모듈을 가져온다.
// npm install express
// npm install morgan - node 로깅하는 thrid party

// 설치 후 프로젝트 폴더 cmd에서 'npm link express'으로 링크걸어야 실행 잘 된다.

const express = require('express')
const logger = require('morgan')
const app = express()
const users = [
    {name: 'Alice'},
    {name: 'Beck'}
]


const generalMw = (req, res, next) => {
    //throw Error('error!')
    next()
}

// error 미들웨어는 인자가 4개이다. 이것으로 error 미들웨어인지 구분
// error 미들웨어는 에러가 났을때만 동작함
const errorMw = (err, req, res, next) => {
    console.log(err.message)
}

// 미들웨어는 인터페이스가 정해져있다.
// request, response, next(미들웨어가 여러개 있을때 다음 미들웨어를 실행시키기위한 콜백함수) 3가지만 받는다.
// 더 사용하기 쉽게 랩핑해놓은 것
const mw = (req, res, next) => {
    console.log('mw!')
    // 미들웨어를 구현한 후 next()함수를 꼭 호출해 주어야 한다.
    next()
}

const mw2 = (req, res, next) => {
    console.log('mw2!')
    next()
}

// 미들웨어의 세팅 순서에 따라 서버의 동작이 바뀐다.
//app.use(mw2)
//app.use(mw)
app.use(logger('dev')) // 개발환경 log를 찍을 때 dev를 씀
app.use(generalMw)
app.use(errorMw)

app.get('/', (req, res) => res.send('Hello World!'))
app.get('/users', (req, res) => res.json(users))


//listen 함수로 서버를 요청 대기 상태로 만든다.
//app.listen(3000, () => console.log('running'))


//commonjs를 구현한 모듈 시스템으로 app 인스턴스를 외부에서도 쓸 수 있게 만들어줌
module.exports = app