<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>  
  
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
            	<form role="form" action="/board/modify" method="post">
            	
            	<!-- 수정,삭제 버튼 클릭 시 pageNum, amount값 전달 -->
            	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
                <input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>  
                <!-- 수정,삭제 버튼 클릭 시 type, keyword값 전달 -->   
                <input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>       	
                <input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>     	          
            	
 					<div class="form-group">
 						<label>Bno</label>
 						<input class="form-control" name="bno" value="<c:out value='${board.bno}'/>" readonly="readonly">
 					</div>
 					<div class="form-group">
 						<label>Title</label>
 						<input class="form-control" name="title" value="<c:out value='${board.title}'/>">
 					</div>
 					<div class="form-group">
 						<label>Text area</label>
 						<textarea rows="3" class="form-control" name="content"><c:out value='${board.content}'/></textarea>
 					</div>
 					<div class="form-group">
 						<label>Writer</label>
 						<input class="form-control" name="writer" value="<c:out value='${board.writer}'/>" readonly="readonly">
 					</div>
 					
 					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
 					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
 					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
	
	let formObj = $("form");
	
	$("button").on("click", function(e) {
		e.preventDefault(); //이벤트의 기본 동작을 막는 역할(전파방지, 클릭해도 넘어가지 않는다)
		
 		let operation = $(this).data("oper");
		
		/* console.log(operation);  */
		
		if(operation === 'remove'){
			formObj.attr("action", "/board/remove")
		}else if(operation === 'list'){
			formObj.attr("action", "/board/list").attr("method", "get");
			//수정화면에서 리스트 클릭시 pageNum, amout, type, keyword값을 가지고 간다
			let pageNumTag = $("input[name='pageNum']").clone();
			let amountTag = $("input[name='amount']").clone();
			let typeTag = $("input[name='type']").clone();
			let keywordTag = $("input[name='keyword']").clone();
			
			formObj.empty();  //input 태그 name 속성값을 클리어
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(typeTag);
			formObj.append(keywordTag);
		}
		formObj.submit();
	});
});
</script>


<%@include file="../includes/footer.jsp"%>