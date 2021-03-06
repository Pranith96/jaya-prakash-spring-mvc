<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
 
<head>
    <title>
        Community Portal Website
    </title>
	
	 <style>
        * {
            margin: 0;
            padding: 0;
        }
 
        .navbar {
            display: flex;
            align-items: center;
            justify-content: center;
            position: sticky;
            top: 0;
            cursor: pointer;
        }
 
        .background {
            background: black;
            background-blend-mode: darken;
            background-size: cover;
        }
 
        .nav-list {
            width: 70%;
            display: flex;
            align-items: center;
        }
 
        .nav-list li {
            list-style: none;
            padding: 26px 30px;
        }
 
        .nav-list li a {
            text-decoration: none;
            color: white;
        }
 
        .nav-list li a:hover {
            color: grey;
        }
  
        .box-main {
            display: flex;
            justify-content: center;
            align-items: center;
            color: black;
            max-width: 80%;
            margin: auto;
            height: 605px;
        }
 
        .firsthalf {
            width: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
 
        .heading-mission {
            font-family: 'Piazzolla', serif;
            font-weight: bold;
            font-size: 35px;
        }
 
        .text-mission {
            font-size: 18px;
			padding-bottom:100px;

        }
		
		.heading-vission {
            font-family: 'Piazzolla', serif;
            font-weight: bold;
            font-size: 35px;
        }
		
		.text-vision {
            font-size: 18px;
        }
 
        .text-footer {
            text-align: center;
            padding: 30px 0;
            font-family: 'Ubuntu', sans-serif;
            display: flex;
            justify-content: center;
            color: white;
        }
    </style>
</head>
 <body>
 <nav class="navbar background">
        <ul class="nav-list">
            <li><a href="http://localhost:8080/communityportal/user/portal/new">Portal Details</a></li>
            <li><a href="http://localhost:8080/communityportal/user/register">Register</a></li>
            <li><a href="http://localhost:8080/communityportal/user">Login</a></li>
        </ul>
        
    </nav>
 
        <div class="box-main">
            <div class="firstHalf">
                <h1 class="heading-mission">
                    Mission:
                </h1>
                <p class="text-mission">
                    Community Portal is an award-winning and leading provider of software in the industry. 
					Our solutions boost productivity, lower costs and help users to communicate grow their businesses. 
					We respect and value our team, and we look to bring the best talent together to make our future even stronger.
					our Company's culture encourages employees to create, think and challenge each other in a fast-paced environment.
					We are determined to shape, not follow, 
					the rapidly changing inindustry by transforming our products and services and identifying new ways to add value for our customers.
                </p>
				 <h1 class="heading-vission">
                    Vision:
                </h1>
				 <p class="text-vision">
                    Community Portal is about relationships, and technology and communication should make those relationships stronger. 
					That's why, at this company, it's our mission to transform the way the industry operates by putting people at the heart of latest technology. 
					By focusing on our customers,
					demanding operational excellence, and delivering results that make a difference, 
					we provide the level of trust and security that every thing will be end to end encyption.
                </p>
            </div>
        </div>
 
  <footer class="background">
        <p class="text-footer">
            Copyright ??-All rights are reserved
        </p>
    </footer>
 </body>
</html>

