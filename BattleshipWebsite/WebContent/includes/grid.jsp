
<tr>
<th></th>
<%
for(int i = 1; i <= 11; i++) {
	if(i==11){
		%>
	   	<th style="visibility:hidden;"><%=i%></th>
	   	<%
	}else{
		%>
	   	<th><%=i%></th>
	   	<%
	}
   	
}
%>
	
</tr>

<%
for(char tblLetter = 'A'; tblLetter <= 'K'; tblLetter++) {
	
	String kString = "K";
	
	if((int)tblLetter == (int)kString.charAt(0)){
	%>
	 	<tr id="<%=tblLetter%>" style="visibility:hidden;">
	 	<th style="visibility:hidden;"><%=tblLetter%></th>
	 <% 
		
	}else{
	%>
	 <tr id="<%=tblLetter%>">
	 <th><%=tblLetter%></th>
	 <% 	
	}
	for(int i = 1; i <= 11; i++) {
		
		if(i == 11 || (int)tblLetter == (int)kString.charAt(0)){
			%>
		   	<td style="visibility:hidden;" class="<%=tblLetter%><%=i%>"></td>
		   	<%
		}else{
			%>
		
			<td class="<%=tblLetter%><%=i%>"></td>
			<%
		}
		
	}
 		%>
</tr>
 	<%
}
%>