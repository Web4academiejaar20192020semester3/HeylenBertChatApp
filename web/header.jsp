<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header role="banner">
    <img alt="Books" src="images/books.jpg">
    <h1><span>Chat App</span></h1>
    <nav>
        <ul>
            <li id="actual"><a href="Controller">Home</a></li>
            <li><a href="Controller?action=GetBlog">Blog</a></li>
            <li><a href="Controller?action=GetRegister">Register</a> </li>
        </ul>
    </nav>
    <h2>
        ${param.title}
    </h2>
</header>