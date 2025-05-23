console.log("Reply Module.......");

//즉시 실행함수
let replyService = (function(){
    
    //1.등록
    function add(reply, callback, error){
        console.log("add reply..........");
        $.ajax({
            type: 'post',
            url: '/replies/new',
            data: JSON.stringify(reply), //reply(js객체)-> json으로 변환
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

        }); 
    } //end add

    //2.전체 데이터 가져오기    
    function getList(param, callback, error){
        let bno = param.bno;
        let page = param.page || 1;

        $.ajax({
            type: 'get',
            url: '/replies/pages/'+bno + "/" + page,

            success: function(result, status, xhr){
                if(callback){
                    callback(result.replyCnt, result.list);
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
    function remove(rno, callback, error) {
       
        $.ajax({
            type:'delete',
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
        
    }; //end remove

    //4.단건 데이터 가져오기    
    function get(rno, callback, error){

        $.ajax({
            type: 'get',
            url: '/replies/' + rno,
            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });

    } //end get

    //5.수정하기
    function update(reply, callback, error){
        $.ajax({
            type: 'put',
            url: '/replies/' + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
          
            success: function(result, status,xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        })
    } //end update

    //날짜, 시간처리(당일 등록 -> 시간, 등록 후 다음날부터 -> 날짜)
    function displayTime(timeValue){

        let today = new Date();
        let gap = today.getTime() - timeValue;

        let dateObj = new Date(timeValue);
        let str = "";

        if(gap < (1000*60*60*24)){
            let hh = dateObj.getHours();
            let mi = dateObj.getMinutes();
            let ss = dateObj.getSeconds();

            return [(hh > 9 ? '' : '0') + hh, ":", 
                    (mi > 9 ? '' : '0') + mi, ":",
                    (ss > 9 ? '' : '0') + ss].join(''); 
        }else{
            let yy = dateObj.getFullYear();
            let mm = dateObj.getMonth() + 1;
            let dd = dateObj.getDate();

            return [yy, '/', (mm > 9 ? '' : '0') + 
                    mm, '/', (dd > 9 ? '' : '0') + dd].join('');
        }       
    }

    return {     //함수 호출(꼭!!)
        add: add,
        getList: getList,
        remove: remove, 
        get: get,
        update: update,
        displayTime:displayTime
    };
})();