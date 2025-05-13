console.log("Reply Module.........");

//즉시 실행함수
let replyService = (function(){

    //1.등록
    function add(reply, callback, error){
        console.log("add reply...............");
        $.ajax({
            type: 'post',
            url: '/replies/new',
            data: JSON.stringify(reply),  //reply(js객체) -> json으로 변환
            contentType: "application/json; charset=utf-8",

            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        })
    } //end add

    //2.전체 데이터 가져오기
    function getList(param, callback, error){
        let bno = param.bno;

        let page = param.page || 1;
        $.ajax({
            type: 'get',
            url: '/replies/pages/' + bno + '/' + page,

            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        })
    } //end getList

    //3.삭제하기
    function remove(rno, callback, error){

        $.ajax({
            type: 'delete',
            url: '/replies/' + rno,

            success: function(deleteResult, status, xhr){
                if(callback){
                    callback(deleteResult);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        })
    } //end remove

    //4.수정하기
    function update(reply, callback, error){
        
        console.log("RNO: " + reply.rno);
        $.ajax({
            type: 'put',
            url: '/replies/' + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",

            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        })
    } //end update

    return {       //함수 호출
        add:add,
        getList:getList,
        remove:remove,
        update:update
    };  
})();