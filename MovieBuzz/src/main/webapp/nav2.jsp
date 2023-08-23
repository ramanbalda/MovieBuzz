<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<nav class="navbar navbar-fixed-top navbar-expand-lg navbar-dark bg-dark navv">
  <div class="container-fluid fixnav">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <a class="navbar-brand " href="allmovies.jsp"> <h1> Movies_Buzz</h1></a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="allmovies.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="allmovies.jsp">Movies</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">Logout</a>
        </li>
      </ul>
      
      <h2 style="
      color: white;
      margin-right: 12px;
      "> <img style="height: 75px;
      width: 150px;
      " src="images/sunshine.png"></h2>
      
      <form class="d-flex">
       <div class="form-control me-2" onclick="newfun()">
       <img style="height: 65px;" src="images/avt.jpg">
       </div>
      </form>
    </div>
  </div>
</nav>






<script type="text/javascript">
let a=true;
function newfun() {
	 if(a==true){
		 document.getElementById("cust").style.display = "inline";
		 a=false;
	 }
	 else{
		 document.getElementById("cust").style.display = "none";
a=true;
		 
	 }
	 
}


</script>




