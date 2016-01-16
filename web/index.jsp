<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <meta name="description" content="Free Bootstrap Themes by 365Bootstrap dot com - Free Responsive Html5 Templates">

  <title>Kingsman</title>

  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/animated-logo.min.css"><!-- Logo -->
  <link rel="stylesheet" href="css/our-team.css"> <!-- Resource style -->

  <!-- Custom Fonts -->
  <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- Js -->
  <script src="js/modernizr.js"></script> <!-- Modernizr -->

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.js"></script>
  <![endif]-->
</head>
<body>
<!-- /////////////////////////////////////////Navigation -->
<jsp:useBean id="inc" class="Bean.IncBean"/>
<jsp:useBean id="news" class="Bean.NewsBean"/>
<jsp:useBean id="items" class="Bean.ItemBean"/>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header page-scroll">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand page-scroll" href="#page-top"><%=inc.getInc_title()%></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="hidden">
          <a href="#page-top"></a>
        </li>
        <li>
          <a class="page-scroll" href="#page-top">Home</a>
        </li>
        <li>
          <a class="page-scroll" href="#services">company</a>
        </li>
        <li>
          <a class="page-scroll" href="#new">news</a>
        </li>
        <li>
          <a class="page-scroll" href="#about">Product</a>
        </li>
        <li>
          <a class="page-scroll" href="#team">Team</a>
        </li>
        <li>
          <a class="page-scroll" href="#contact">Contact</a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container-fluid -->
</nav>
<!-- Navigation -->

<!-- /////////////////////////////////////////Header -->
<header id="page-top">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="o-container">
          <div class="c-slack">
            <span class="c-slack__dot c-slack__dot--a"></span>
            <span class="c-slack__dot c-slack__dot--b"></span>
            <span class="c-slack__dot c-slack__dot--c"></span>
            <span class="c-slack__dot c-slack__dot--d"></span>
          </div>
        </div>
        <div class="intro-text">
          <div class="intro-lead-in">Welcome To Our Company!</div>
          <div class="intro-heading">It's Nice To Meet You</div>
        </div>
        <a class="btn btn-1 btn-sm" href="#about">Product</a>
        <a class="btn btn-1 btn-sm" href="#team">Our Team</a>
      </div>
    </div>
  </div>
</header>
<!-- Header -->

<!-- /////////////////////////////////////////Content -->
<div id="page-content" class="index-page">

  <!-- ////////////Content Box 01 -->
  <section id="services" class="box-content box-1">
    <div class="container">
      <div class="row heading">
        <div class="col-lg-12">
          <h2><%=inc.getInc_title()%></h2>
          <hr>
          <div class="intro"><%=inc.getInc_value()%></div>
        </div>
      </div>

    </div>
  </section>

  <!-- ////////////Content Box 02 -->

  <section id="new" class="box-content box-2 box-style">
    <c:forEach items="${news.all}" var="temp">
    <div class="container">
      <div class="row">
        <blockquote>${temp.news_title}</blockquote>
      </div>
    </div>
    </c:forEach>
  </section>

  <!-- ////////////Content Box 03 -->
  <section id="about" class="box-content box-3">
    <div class="container">
      <div class="row heading">
        <div class="col-lg-12">
          <h2>Product</h2>
          <hr>
          <div class="intro"><font face="微软雅黑"> 神产品介绍</font></div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="timeline">
            <c:forEach items="${items.all}" var="temp">
            <li class="${temp.iclass}">
              <div class="timeline-image">
                <img class="img-circle img-responsive" src="${temp.isrc}" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>${temp.item_name}</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">${temp.item_info}</p>
                </div>
              </div>
            </li>
            </c:forEach>


            <li class="timeline-inverted ">
              <div class="timeline-image">
                <h4>更多产品

                  <br>敬请期待
                  <br>污瞄王
                </h4>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>

  <!-- ////////////Content Box 04 -->
  <section id="team" class="box-content box-4 box-style">
    <div class="clearfix">
      <div class="cd-testimonials-wrapper cd-container">
        <ul class="cd-testimonials">
          <li>
            <p><font face="微软雅黑"> 首席技术工程师兼CEO兼董事.</font></p>
            <div class="cd-author">
              <img src="images/avatar-1.jpg" alt="Author image">
              <ul class="cd-author-info">
                <li>Wang Jinghao</li>
                <li>CEO,Technical Director</li>
              </ul>
            </div>
          </li>

        </ul> <!-- cd-testimonials -->
      </div> <!-- cd-testimonials-wrapper -->

      <div class="cd-see-all"><a href="#0" class="btn btn-1">See all</a></div>

      <div class="cd-testimonials-all">
        <div class="cd-testimonials-all-wrapper">
          <ul>
            <li class="cd-testimonials-item">
              <p>负责项目Servlet和Dao的后台设计制作，给团队提供技术指导</p>

              <div class="cd-author">
                <img src="images/avatar-1.jpg" alt="Author image">
                <ul class="cd-author-info">
                  <li>王竞豪</li>
                </ul>
              </div> <!-- cd-author -->
            </li>
            <li class="cd-testimonials-item">
              <p>测试及问题、BUG的修复 保证项目可靠性.</p>

              <div class="cd-author">
                <img src="images/avatar-2.jpg" alt="Author image">
                <ul class="cd-author-info">

                  <li>徐明</li>
                </ul>
              </div> <!-- cd-author -->
            </li>
            <li class="cd-testimonials-item">
              <p>前台 JavaBean 的设计制作同时协作完成DAO、网页的测试 不参与修复BUG</p>

              <div class="cd-author">
                <img src="images/avatar-3.jpg" alt="Author image">
                <ul class="cd-author-info">

                  <li>姜鑫鹏</li>
                </ul>
              </div> <!-- cd-author -->
            </li>
            <li class="cd-testimonials-item">
              <p>数据库设计 、及后期修改</p>

              <div class="cd-author">
                <img src="images/avatar-4.jpg" alt="Author image">
                <ul class="cd-author-info">

                  <li>杨志峰</li>
                </ul>
              </div> <!-- cd-author -->
            </li>
            <li class="cd-testimonials-item">
              <p>收集资源，前台页面修改、完善JavaBean</p>

              <div class="cd-author">
                <img src="images/avatar-5.jpg" alt="Author image">
                <ul class="cd-author-info">

                  <li>钱伟琦</li>
                </ul>
              </div> <!-- cd-author -->
            </li>
          </ul>
        </div>	<!-- cd-testimonials-all-wrapper -->
        <a href="#0" class="close-btn">Close</a>
      </div> <!-- cd-testimonials-all -->
    </div>
  </section>

  <!-- ////////////Content Box 05 -->
  <section class="box-content box-5" id="contact">
    <div class="container">
      <div class="row heading">
        <div class="col-lg-12">
          <h2><font face="微软雅黑">Contact us</font> </h2>
          <hr>
          <div class="intro"> Please leave a message below.</div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4 ">
          <div class="row box-item">
            <h3>Or Just Make a Call</h3>
            <p>+86 15158130302</p>
            <p>winfath@foxmail.com</p>
          </div>
        </div>
        <div class="col-md-8">
          <div id="contact-form">
            <form name="form1" method="post" action="message">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <input type="text" class="form-control input-lg" name="uname" id="name" placeholder="Enter name" required="required" />
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <input type="email" class="form-control input-lg" name="uemail" id="email" placeholder="Enter email" required="required" />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
                    <input type="text" class="form-control input-lg" name="utitle" id="subject" placeholder="Title" required="required" />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
											<textarea name="umessage" id="message" class="form-control" rows="4" cols="25" required
                                                      placeholder="Message" ></textarea>
                  </div>
                  <button type="submit" class="btn btn-3 btn-block" name="btnContactUs" id="btnContactUs">
                    Submit</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>

</div>

<!-- /////////////////////////////////////////Footer -->

<!-- Footer -->


<!-- jQuery -->
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/masonry.pkgd.min.js"></script>
<script src="js/jquery.flexslider-min.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/agency.js"></script>

<!-- Animated Top -->
<script src="js/jquery.easing.min.js"></script>
<script src="js/classie.js"></script>
<script src="js/cbpAnimatedHeader.js"></script>
${message }


</body>
</html>