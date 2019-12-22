//
// controller 코드만 옮긴 파일
//

let users = [
    {id: 1, name: 'Alice'},
    {id: 2, name: 'Beck'},
    {id: 3, name: 'chris'}
]

const index = (req, res) => {
    req.query.limit = req.query.limit || 10 //limit 요청 안하면 default값 10, , 10 "10" "ten"이 될 수도
    const limit = parseInt(req.query.limit, 10) // limit값은 문자열로 왔을테니 10진수로 바꾸는 작업 수행
    // limit 쿼리 값에 숫자가 아닌 값이 들어왔으면 limit변수에 숫자가 아닌 값이 들어올테니 이걸로 분기치면 됨
    if(isNaN(limit) == true){
        return res.sendStatus(400)
    }else{
        res.json(users.slice(0, limit)) // users 배열을 limit 길이만큼 쪼개서 보내준다.
    } 
}

const show = (req, res) => {
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
}

const destroy = (req, res) => {
    // id 값을 얻어낸다.
    const id = parseInt(req.params.id, 10)

    if(isNaN(id) == true){
        return res.sendStatus(400).end()
    }else{
        users = users.filter(aaa => aaa.id !== id)
        res.status(204).end()
    }
}

const create = (req, res) => {
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
    
}

// api/user/index.js 에 넘겨주기 위하여
module.exports = {
    index,
    show,
    destroy,
    create
}