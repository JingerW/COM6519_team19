<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Student Helper</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

<div id="header"> <%@ include file="./pages/header.jsp" %> </div>

<div id="content" style="height:800px;">

<div class="jumbotron mb-0">
  <div class="text-center">
  
    <h1>Help Student's Daily Life</h1>
    <p>Too many classes? Can't remember dead lines? Always wait until last minutes?</p>	
    <p>Don't worry! Student Helper is here to help you out!</p>
    
    <div id="applicationSlider" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#application0" data-slide-to="0" class="active"></li>
        <li data-target="#application1" data-slide-to="1"></li>
        <li data-target="#application2" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img class="d-block img-fluid rounded mx-auto" src="https://via.placeholder.com/350x350" alt="First slide">
          <div class="carousel-caption d-none d-md-block">
            <h5>Application1</h5>
            <p>Some text for description</p>
          </div>
        </div>
        <div class="carousel-item">
          <img class="d-block img-fluid rounded mx-auto" src="https://via.placeholder.com/350x350" alt="Second slide">
          <div class="carousel-caption d-none d-md-block">
            <h5>Application2</h5>
            <p>Some text for description</p>
          </div>
        </div>
        <div class="carousel-item">
          <img class="d-block img-fluid rounded mx-auto" src="https://via.placeholder.com/350x350" alt="Third slide">
          <div class="carousel-caption d-none d-md-block">
            <h5>Application3</h5>
            <p>Some text for description</p>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#applicationSlider" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#applicationSlider" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    
  </div>

</div>
</div>

<div id="footer"> <%@ include file="./pages/footer.jsp" %> </div>

</body>
