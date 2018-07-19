<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guests</title>


<style>
	/*
	Color fondo: #632432;
	Color header: 246355;
	Color borde: 0F362D;
	Color iluminado: 369681;
*/
body{
	background-color: #246355;
	font-family: Arial;
}

#main-container{

	width: 1200px;
	margin: 0 auto;
	
}

table{
	background-color: white;
	text-align: left;
	border-collapse: collapse;
	width: 100%;
	
}

th, td{
	padding: 8px;
}

thead{
	background-color: #638060;
	border-bottom: solid 5px #0F362D;
	color: white;
}

tr:nth-child(even){
	background-color: #ddd;
}

tr:hover td{
	background-color: #369681;
	color: white;
}


#menu{
			background-color: #000;
		}
		#menu ul{
			list-style: none;
			margin: 0;
			padding: 0;
		}
		#menu ul li{
			display: inline-block;
		}
		#menu ul li a{
			color: white;
			display: block;
			padding: 20px 20px;
			text-decoration: none;
		}
		#menu ul li a:hover{
			background-color: #42B881;
		}
		.item-r{
			float: right;
		}

#menu2{
			background-color: #000;
						float: center;
						widght:19px;
			
			
		}
		#menu2 ul{
			list-style: none;
			margin: 0;
			padding: 0;
		
		}
		#menu2 ul li{
			display: block;
			
		}
		#menu2 ul li a{
			color: white;
			display: block;
			padding: 10px 20px;
			text-decoration: none;
			
		}
		#menu2 ul li a:hover{
			background-color: #42B881;
			
		}
		 .item-r{
			float: right;
		}
		
	</style>







</head>
<body>
	<%@ page import="java.util.List"%>
	<%@ page import="model.entity.*"%>

	
	<div id="menu">
		<ul>
			<li><a href="/..">Inicio</a></li>
			<li><a href="/users">Usuarios</a></li>
			<li><a href="/products">Productos</a></li>
			
			
			<li class="item-r"><a href="/logout">Cerrar sesion</a></li>
						
		</ul>
	</div>
	
	
	<div id="menu2">
		<ul>
		<li><a href="/products/add?action=productCreate" />Crea un nuevo Producto</a></li>
			
				
			
		</ul>
	</div>
	
	
	
	<%
		List<Producto> products = (List<Producto>) request.getAttribute("products");
	%>
	<%if (products.size() > 0) {%>
		
		<div id="main-container">
		
		<table align="right">
		<thead>
            <tr >
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Unidades</th>
                
            </tr>
        </thead>
	<%for (int i = 0; i < products.size(); i++) {%>
		<%Producto g= (Producto)products.get(i) ; %>
        
        <tbody>
            
            
            <tr>
                <td><%=g.getId()%></td>
                <td><%=g.getNombre()%></td>
                <td><%=g.getPrecio()%></td>
                <td><%=g.getCantidad()%></td>
                
                <td class="actions">
                    <a href="/products/view?id=<%=g.getId()%>">View</a>
                	<a href="/products/edit?id=<%=g.getId()%>">Edit</a>
                	<form name="post_<%=g.getId() %>" style="display:none;" method="post" action="/products/delete"><input type="hidden" name="id" value="<%=g.getId() %>"/></form><a href="#" onclick="if (confirm(&quot;Are you sure you want to delete # <%=g.getId() %>?&quot;)) { document.post_<%=g.getId() %>.submit(); } event.returnValue = false; return false;">Delete</a>                    
                </td>
            </tr>
            
        </tbody>
    
		
		<%} %>
		
		</table>
		
		</div>
		
		
	<%} %>
	
	

</body>
</html>