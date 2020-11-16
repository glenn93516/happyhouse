<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/5d2954c3f8.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-sm navbar-default py-3 border-bottom justify-content-between">
        <div class="navbar navbar__logo">
            <i class="fas fa-home logo pr-1"></i>
            <a class="navbar-brand happy-font title" href="main.html">해피</a>
        </div>

        <div class="navbar navbar__menu">
            <ul class="navbar-nav menu mx-md-3">
                <li class="nav-item">
                    <a href="#" class="nav-link font-weight-bold text-dark">공지사항</a>
                </li>
                <li class="nav-item">
                    <a href="search.html" class="nav-link font-weight-bold text-dark">실거래가 검색</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <button class="btn btn-outline-primary mr-2" data-toggle="modal" data-target="#join">회원가입</button>
                <button class="btn btn-outline-primary" data-toggle="modal" data-target="#login">로그인</button>
            </ul>

        </div>
    </nav>

    <!-- Contents -->
    <div class="container-fluid text-center" style="background: url('img/background.png');">
        <p class="font-weight-bolder p-md-5" style="font-size: 40px; color: white;"><i
                class="fas fa-home logo pr-1 mx-md-3" style="font-size:40px; color: white;"></i>해피</p>
        <div class="jumbotron bg-transparent">
            <h1 class="font-weight-bold" style="color: white;">Lorem ipsum dolor sit amet, consectetur
                Cum accusantium</h1>
            <p class="p-md-5" style="font-size:24px; color: white;">
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dolores necessitatibus, velit atque ea optio
                quod, id, ut ducimus laudantium fugit impedit quia perferendis itaque accusamus molestiae provident.
                Magnam, nisi earum!
            </p>
            <p class="p-md-3" style="font-size:24px; color: white;">
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dolores necessitatibus, velit atque ea optio
                quod, id, ut ducimus laudantium fugit impedit quia perferendis itaque accusamus molestiae provident.
                Magnam, nisi earum!
            </p>
            <p class="p-md-3" style="font-size:24px; color: white;">
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dolores necessitatibus, velit atque ea optio
                quod, id, ut ducimus laudantium fugit impedit quia perferendis itaque accusamus molestiae provident.
                Magnam, nisi earum!
            </p>
        </div>
    </div>
    <!-- Footer -->
    <footer class="footer bg-light py-3 my-md-3">
        <!-- 사이트 맵 -->
        <div class="row justify-content-end">
            <div class="col-3">
                <i class="fas fa-home logo pr-1 d-block" style="color:black; font-size: 48px;"></i>
                <small class="text-muted">© 2020</small>
            </div>
            <div class="col-3">
                <h3>Features</h3>
                <ul class="list-unstyled">
                    <li><a href="" class="text-muted">공지사항</a></li>
                    <li><a href="" class="text-muted">실거래가 검색</a></li>
                    <li><a href="" class="text-muted">관심지역 동네 업종 정보</a></li>
                    <li><a href="" class="text-muted">관심지역 대기 오염 정보</a></li>
                </ul>
            </div>
            <div class="col-3">
                <h3>About</h3>
                <ul class="list-unstyled">
                    <li><a href="" class="text-muted">소개</a></li>
                    <li><a href="" class="text-muted">위치</a></li>
                </ul>
            </div>
        </div>


        <!-- CopyRight -->
        <div class="container">
            <span class="text-muted float-right">Copyright 2020. 김민혁정다운. ALL RIGHTS RESERVED</span>
        </div>
    </footer>
</body>

</html>
