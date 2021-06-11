<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#loginChk").hide();
	});
	
	function login(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var loginVal = {
				"memberid": memberid,
				"memberpw": memberpw
		}
		
		if(memberid==null || memberid=="" || memberpw ==null || memberpw==""){
			alert("ID 및 PW를 다시 확인해 주세요");
		}else {
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				data:JSON.stringify(loginVal),	/* id랑 pw를 가지고 json 형태로 ajax를 보내줌 */ 	/* contentType 은 json객체야 하고 알려주는애 */
				contentType:"application/json", /*넘어가는게 json형태의 문자열이었는데 json객체로 바꿔서 넘어갔다. 그게 requestbody에 저장 된다. json타입으로 보내고 있다 */
				dataType:"json",				/* map이라는 자바객체가 json으로 바뀌어 응답했습니다 */
				success:function(msg){
					if (msg.check == true) {
						location.href="list.do";
					} else {
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW가 잘못 되었습니다.");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
</script>

</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"/></td>
		</tr>
		
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="button" value="login" onclick="login();"></td>
			<td colspan="2"><input type="button" value="regist" onclick="location.href='registform.do'"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>

<!-- 
1.ajax가 ajaxlogin.do해서 controller를 찾는다.

2.JSON.stringify(loginVal)통해 json문자열로 변환된 데이터를

3.contentType"application/json"으로 json문자열을 json 객체로 변환시켜서 

4.controller의 @requestBody를 통해서 
request에 담긴 json객체를 MYMemberDto 에 set 시켜놓고
(이때 jackson이 변환해줌)

5.체크시켜서 map형태로 리턴하는데,
response 객체에 담아서 jackson이 json으로 바꿔주고

6.ajax에서 리턴받은 json을 받아서

7.성공했을때 list.do, 실패했을때 "ID혹은 PW가 잘못되었습니다"


 -->









