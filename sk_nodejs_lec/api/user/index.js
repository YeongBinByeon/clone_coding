//
// Api/user/index.js 파일에 users 관련된 api들 일괄 이동하였음
//


const express = require('express')
const router = express.Router()
// 따로 분리해놓은 컨트롤러를 가져온다.
const ctrl = require('./user.ctrl.js')


// npm start 명령어로 실행
// ex_test.js에서 app.use('/users', user)으로 경로를 설정해놓았기 때문에 /users 이후에 나오는 경로들에 대해서만
// 설정해 주어도 된다.
// ctrl에 작성한 index함수를 바인딩해준다. (리팩토링 하는법)
router.get('/', ctrl.index)
router.get('/:id', ctrl.show)

router.delete('/:id', ctrl.destroy)

router.post('/', ctrl.create)

// 이렇게 적으면 node에서 module이 되고 다른 노드 파일에서 사용할 수 있게 된다.
module.exports = router