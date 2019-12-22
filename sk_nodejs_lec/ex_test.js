// node를 설치하면 npm도 자동으로 설치된다.
// 아래 명령어로 어딘가에 저장되어있는 express 모듈을 가져온다.
// npm install express
// npm install morgan - node 로깅하는 thrid party

// 설치 후 프로젝트 폴더 cmd에서 'npm link express'으로 링크걸어야 실행 잘 된다.

const express = require('express')
const logger = require('morgan')
const bodyParser = require('body-parser')
const app = express()
let users = [
    {id: 1, name: 'Alice'},
    {id: 2, name: 'Beck'},
    {id: 3, name: 'chris'}
]

//body parser는 middle웨어이기에 use()로 추가해주어야 한다.
// json 타입으로 body를 받는다는 의미
app.use(bodyParser.json())
// url에 영어가 아니라 한글이나 특문이 오면 encoding이 깨지는대, 그것을 위한 옵션
app.use(bodyParser.urlencoded({ extended: true}))
app.use(logger('dev')) // 개발환경 log를 찍을 때 dev를 씀

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
app.use(generalMw)
app.use(errorMw)


// npm start 명령어로 실행
app.get('/', (req, res) => res.send('Hello World!'))
app.get('/users', (req, res) => {
    req.query.limit = req.query.limit || 10 //limit 요청 안하면 default값 10, , 10 "10" "ten"이 될 수도
    const limit = parseInt(req.query.limit, 10) // limit값은 문자열로 왔을테니 10진수로 바꾸는 작업 수행
    // limit 쿼리 값에 숫자가 아닌 값이 들어왔으면 limit변수에 숫자가 아닌 값이 들어올테니 이걸로 분기치면 됨
    if(isNaN(limit) == true){
        return res.sendStatus(400)
    }else{
        res.json(users.slice(0, limit)) // users 배열을 limit 길이만큼 쪼개서 보내준다.
    } 
})
app.get('/users/:id', (req, res) => {
    // id 값을 얻어낸다.
    const id = parseInt(req.params.id, 10)

    if(isNaN(id) == true){
        return res.sendStatus(400)
    }else{
        // users 배열 조회
        // 아래 filter 메서드는 users 배열을 돌면서 user.id값과 id값이 일치하는 객체만 뽑아서 배열에 저장한다는 의미.
        // 따라서 찾은 값은 0번째 배열에 저장되어 있을 것임. 
        const user = users.filter(kkk => kkk.id === id)[0]
        // js에서는 null체크를 주로 이렇게 함. 
        if(!user){
            return res.status(404).end()
        }else{
            // 응답 : res
            res.json(user)
        }
    }
})

app.delete('/users/:id', (req, res) => {
    // id 값을 얻어낸다.
    const id = parseInt(req.params.id, 10)

    if(isNaN(id) == true){
        return res.sendStatus(400).end()
    }else{
        user = users.filter(aaa => aaa.id !== id)
        res.status(204).end()
    }
})

app.post('/users', (req, res) => {
    const name = req.body.name
    if(!name){
        return res.status(400).end()
    }

    // users 배열 안에 name이 body에서 추출한 name과 같은 녀석이 있는지 체크하고, length로 배열의 길이를 체크함.
    // 배열의 length가 1이면 중복된 name이 있다는 의미이므로 아래 분기문에서 409 넘기고 종료
    const found = users.filter(bbb => bbb.name === name).length
    if(found) {
        return res.status(409).end()
    }

    const id = Date.now() // 현재 시간이 초단위로 나옴
    const user = {id, name} // { #, # }는 javascript ES6 문법
    users.push(user)
    res.status(201).json(user)
    
})


//commonjs를 구현한 모듈 시스템으로 app 인스턴스를 외부에서도 쓸 수 있게 만들어줌
module.exports = app