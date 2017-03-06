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

counterTable = -1;

for(Character tblLetter = 'A'; tblLetter <= 'K'; tblLetter++) {
	
	counterTable += 1;
	
	if(counterTable == 10){
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
		
		if(i == 11 || counterTable == 10){
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