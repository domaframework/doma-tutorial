<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%@ include file="common/header.jsp" %>

<div id="Welcome">
  <div id="WelcomeContent">
    <c:if test="${not empty SIGNIN && SIGNIN.authenticated}">
      Welcome ${f:h(SIGNIN.firstName)}!<br/>
    </c:if>
    <html:messages id="message" message="true">
      ${message}
    </html:messages>
  </div>
</div>

<div id="Main">
  <div id="Sidebar">
    <div id="SidebarContent">
      <a href="catalog/viewCategory/FISH">
        <img src="${f:url('/images/fish_icon.gif')}"/>
      </a>
      <br/>
      Saltwater, Freshwater
      <br/>
      <a href="catalog/viewCategory/DOGS">
        <img src="${f:url('/images/dogs_icon.gif')}"/></a>
      <br/>
      Various Breeds
      <br/>
      <a href="catalog/viewCategory/CATS">
        <img src="${f:url('/images/cats_icon.gif')}"/></a>
      <br/>
      Various Breeds, Exotic Varieties
      <br/>
      <a href="catalog/viewCategory/REPTILES">
        <img src="${f:url('/images/reptiles_icon.gif')}"/></a>
      <br/>
      Lizards, Turtles, Snakes
      <br/>
      <s:link href="/catalog/viewCategory/BIRDS">
        <img src="${f:url('/images/birds_icon.gif')}"/></s:link>
      <br/>Exotic Varieties
    </div>
  </div>

  <div id="MainImage">
    <div id="MainImageContent">
      <map name="estoremap"><area alt="Birds" coords="72,2,280,250" href="${f:url('/catalog/viewCategory/BIRDS')}"
                                  shape="RECT"/>
        <area alt="Fish" coords="2,180,72,250" href="catalog/viewCategory/FISH" shape="RECT"/>
        <area alt="Dogs" coords="60,250,130,320" href="/catalog/viewCategory/DOGS" shape="RECT"/>
        <area alt="Reptiles" coords="140,270,210,340" href="/catalog/viewCategory/REPTILES"
              shape="RECT"/>
        <area alt="Cats" coords="225,240,295,310" href="/catalog/viewCategory/CATS'" shape="RECT"/>
        <area alt="Birds" coords="280,180,350,250" href="/catalog/viewCategory/BIRDS" shape="RECT"/>
      </map>
      <img height="355" src="${f:url('/images/splash.gif')}" align="center" usemap="#estoremap" width="350"/>
    </div>
  </div>

  <div id="Separator">&nbsp;</div>
</div>

<%@ include file="common/footer.jsp" %>


</body>
</html>