<tr>
<th></th>
<%
for(int i = 1; i <= 10; i++) {
   	%>
   	<th><%=i%></th>
   	<%
}
%>
	
</tr>

<%

for(char tblLetter = 'A'; tblLetter <= 'J'; tblLetter++) {
  	%>
 	<tr id="<%=tblLetter%>">
 		<th><%=tblLetter%></th>
 		<% 
	for(int i = 1; i <= 10; i++) {
		%>
		
		<td class="<%=tblLetter%><%=i%>"></td>
		<%
		
	}
 		%>
</tr>
 	<%
}
%>