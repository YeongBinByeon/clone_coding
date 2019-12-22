const assert = require('assert')
const should = require('should')
const request = require('supertest')
// express 모듈을 ex_test.js 에서 가져옴
const app = require('../../ex_test.js')



// 인자가 2개 들어감, 1번째는 테스트할 API, 2번째는 함수를 넘겨준다.(테스트 코드 작성)
describe('GET /users', () => {
    describe('성공', () => {
        it('배열을 반환한다.', (done) => {
            //아래는 2개의 인자가 같아야만 하는 함수, 다르면 exception을 던져버림
            //assert.equal(1,2)
            //(1).should.equal(1)
            request(app).get('/users').end((err, res) => {
                //응답값이 배열이라는 것과
                res.body.should.be.instanceof(Array)
                //배열안에 name이라는 key를 가지고 있어야 한다
                res.body.forEach(user => {
                    user.should.have.property('name')
                })
                console.log(res.body)
    
                //비동기방식이기에 test를 완료하면 done()을 호출해 주어야지만 mocha가 작업 완료를 알 수 있다.
                done()
            })
        })
        //5강부분 코드, TDD로 api 서버 개발 부분
        it('최대 limit 갯수만큼 응답한다.', done => {
            request(app)
            .get('/users?limit=2')
            .end((err, res) => {
                res.body.should.have.lengthOf(2)
                done()
            })
        })
    })
    describe('실패', () => {
        it('limit이 정수가 아니면 400을 응답한다.', done => {
            request(app)
            .get('/users?limit=two')
            .expect(400)
            .end(done)
            //expect 함수는 상태값만 체크하는 함수이다.
        })
    })
})

describe('GET /users/:id', () => {
    describe('성공', () => {
        it('유저 객체를 반환한다.', done => {
             request(app)
             .get('/users/1')
             .end((err, res) => {
                 //response body에 user 객체가 넘어올거고, id값은 1일것이다.
                 res.body.should.have.property('id', 1)
                 done()
             })
        })
    })
    describe('실패', () => {
        it('id가 숫자가 아닐경우 400으로 응답한다.', (done) => {
            request(app)
            .get('/users/one')
            .expect(400)
            .end(done)
        })
        it('id로 유저를 찾을 수 없을 경우 404로 응답한다.', (done) => {
            request(app)
            .get('/users/10')
            .expect(404)
            .end(done)
        })
    })
})

describe('DELETE /users/:id', () => {
    describe('성공', () => {
        it('204 응답', done => {
            request(app)
            .delete('/users/3')
            .expect(204)
            .end(done)
        })
    })
    describe('실패', () => {
        it('id가 숫자가 아닐경우 400', done => {
            request(app)
            .delete('/users/three')
            .expect(400)
            .end(done)
        })
    })
})

describe('POST /users', () => {
    describe('성공', () => {
        it('201을 응답, 생성한 유저 객체를 응답', done => {
            // body는 send 함수로 전달한다.
            request(app).post('/users').send({name:'Daniel'})
            .expect(201)
            .end((err, res) => {
                //response body 객체를 통해서 유저 정보가 올 것임
                //body에는 name이라는 property가 있을 것이고, Daniel 값이 있을 것임
                res.body.should.have.property('name', 'Daniel')
                //test가 완료되면 done 함수로 종료하면 된다.
                done()
            })
        })
    })
    describe('실패', () => {
        it('name이 없으면 400 응답', done => {
            request(app).post('/users').send({})
            .expect(400).end(done)
        })
        it('name이 중복이면 409 응답', done => {
            request(app).post('/users').send({name:'Alice'})
            .expect(409).end(done)
        })
    })
})