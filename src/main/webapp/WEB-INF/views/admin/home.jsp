<%--
    Document   : newjsp
    Created on : 3 Aug, 2020, 7:15:26 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            hr {
                border: 0;
                border-top: 1px solid rgba(0, 0, 0, 0.1);
                margin-bottom: 15px!important;
                padding: 0px!important;
            }
            ul{
                list-style: none;
            }

            ul a{
                text-decoration: none;
                color: grey;
            }
            ul li{
                padding-left: 10px;
            }
        </style>
    </head>
    <body>

        <%@include file="common/header.jsp" %>
        <br>

        <div class="container">

            <div class="row">
                <div class="col-sm-6">

                    <ul class="" aria-labelledby="dropdownMenu">
                        <a href="./../fruit/Dashboard?id=${FruitMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Fruit</li></a>
                        <a href="./../seed/Dashboard?id=${SeedMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Seed</li></a>
                        <a href="./../root/Dashboard?id=${RootMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Root</li></a>
                        <a href="./../mybranch/Dashboard?id=${MyBranchMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Branch</li></a>
                        <a href="./../trunk/Dashboard?id=${TrunkMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Trunk</li></a>
                        <a href="./../sprig/Dashboard?subid=${SubSprigMainService.getMainRepository().findTopByOrderByIdAsc().getId()}&id=${SprigMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Sprig</li></a>
                        <a href="./../leaf/Dashboard?id=${LeafMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Leaf</li></a>
                        <a href="./../flower/Dashboard?id=${FlowerMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Flower</li></a>
                        <a href="./../role/Dashboard?id=${RoleMainService.getMainRepository().findTopByOrderByIdAsc().getId()}"><li class="list-item">Role</li></a>
                    </ul>
                </div>
            </div>

        </div>

    </body>
</html>


