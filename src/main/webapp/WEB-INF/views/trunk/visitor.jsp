<%--
    Document   : visitor
    Created on : Aug 28, 2020, 10:08:50 AM
    Author     : Ramesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
   <head>
      <title>G-ERP Visitor </title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="../../css/bootstrap.css"/>
      <link rel="stylesheet" href="../../css/Mystyle.css"/>
      <link rel="stylesheet" href="../../icofont/icofont.css"/>
      <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>

   </head>
   <body>

      <!-- Start of Top Header  A row------------------------------------->

      <%@include file="../common/header.jsp"%>


      <!-- End    of   Top Header   A row------------------------------------->































      <!-- Start of logo Navigation B row------------------------------------->


      <div id="myCompHeaderhideShow" class= "container-fluid" style="display: none; border-bottom: 0px  solid #1560bd; padding: 1px; margin: 0px; color: #004085">



	<div class=row style="border-bottom: 0px #000066 solid  ;padding: 0px; margin: 0px; height: 60px">

	   <div class="col-sm-1 imageFitUser text-center" style="padding: 0px ; border-left: 1px #0056b3 solid; border-right: 1px #bbbbff solid; max-height: 88px; max-width: 112px">

	      <a href="#" ><img src="image/Logo.png" alt=""/> </a>

	   </div>


	   <div class="col-sm-4 text-justify " style=" border: 0px solid #1560bd; font-size: 11px; letter-spacing: 1.25px; line-height: 12px">
	      <b>Opam-G Infocons Industries Ltd.</b>

	      <br>
	      CIN- U2456666BR201778999  <br>
	      Business Address- H No-58 D, Road No-01, Ashok Nagar, <br>
	      Dist- Ranchi-834002, Jharkahnd
	      Phone- 0651 2240165, Email- opamg2017@gmail.com,


	   </div>


	   <div class="col-sm-6 text-right" style="border-right: 1px #bbbbff solid; border-left: 1px #bbbbff solid">




	   </div>


	   <div class="col-sm-1 imageFitUser text-center" style=" padding: 10px 0px 0px 0px ; border-right: 1px #0056b3 solid;  max-width: 112px">

	      <a style=" text-decoration: none; font-size: 11px" href="#" ><img src="image/UserLogo.png" alt=""/><br> <b>Ramesh Kr. Sinha</b> </a>



	   </div>
	</div>
      </div>



      <!-- End of logo Navigation   B row------------------------------------->





























      <!-- Start C row ------------------------------------>



      <div class= "container-fluid  "  >

	<div class="row" style="border-top: 1px #000099 solid">

	   <div class="col-sm-1 text-center"  style="border-right: 1px #007bff solid; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">

	      Info-Ledger

	   </div>







	   <div class="col-sm-10 text-center"  style="border: 0px #000 solid  ; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">

	      <div class="row">
		<div class="col-sm-1">

		</div>

		<div class="col-sm-10">
		   <span style="background-color: red; padding: 2px 20px 2px 20px; color: white">         Info- Ledger of Visitor     </span>
		</div>

		<div class="col-sm-1" style="display: inline-block">
		   <button style=" font-size: 5px; background:  #000099"   onclick="myHeadeRFunction()">Try it</button>
		   <button style=" font-size: 5px; background:  #000099"   onclick="myGraphFunction()">Try it</button>
		</div>
	      </div>
	   </div>





	   <div class="col-sm-1 text-center"  style="border-left: 1px #007bff solid; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">

	      User Action

	   </div>

	</div>
      </div>

      <!-- End   C row ------------------------------------>

















      <!--------------Start Department and Info Ledger Horizontol Menu  side------------------------------->



      <div class="container-fluid text-center" style=" font-size: 13px; background-color: white; color: white; font-weight: 500; border-top: 1px #1560bd solid;  border-shadow:50px 10px">

	<div class="row">


	   <div   class="col-sm-1 dashboarderp text-left" style=" background-color: #1560bd; margin-left: 0px ; padding: 0px 1px 0px 2px; font-size: 10px; letter-spacing: 2px;  color: white">


	      <ul>

		<a href="G-ERPVisitoR"> <li> Visitor </li> </a>

		<a href="G-ERPCustomeR"> <li> Customer </li> </a>



	      </ul>


	      <div class="col-sm-1 text-center"  style="border-left: 1px solid #1560bd; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 8px 2px 8px 2px">

		Department

	      </div>
	      <ul>



	      </ul>


	   </div>


	   <!--------------End Department Horizontol Menu------------------------------->










































	   <!--------------Visitor START-------middle column------------------------------------------------------>



	   <div   class="col-sm-10  text-left" style=" border:0px #00ff66 solid; background-color: whitesmoke; color: #99ff99 ; margin-top: 0px ; padding: 1px; font-size: 10px; letter-spacing: 2px;  color: white; line-height: 12px">

	      <!------------Graph Data Sheet start---------->

	      <div id="myGraphhideShow" class="row" style="display: block">

		<div  class="container text-center" style=" background-color: #fcfcc6   ;border: 0px  #0056b3 solid; color: #061148 ; margin-left: 15px; margin-right: 15px; height: 150px">

		   Graph Input
		</div>

	      </div>

	      <!------------Graph Data Sheet end--------->


	      <!--******************************************Tab wrap*********************************************************************************************-->




	      <div class="row">

		<div class="container" style=" background: #061148;  margin: 0px 12px 0px 15px; padding: 2px; height: 577px">

		   <ul class="tab-wrap " >









		      <!-------------Costumer Tab  Start---------------ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt------>

		      <li>
			<input type="radio" id="tab-40" name="tab" checked="yes"/>
			<label for="tab-40"> <p tabindex="3">Costumer</p> </label>



			<!-----------Backend Server site Data fetch showing  row column start---------------------->

			,<div class="tab-content">

			   <div style="display: inline-block"><button type="button" id="myBtn1" data-toggle="modal" data-target="#myvisitorcoStumerTab"> New</button><div style="display: inline-block; width: 600px"></div><input type="search" placeholder="Search" style="height: 20px; width: 250px; padding-left: 5px; font-size: 12px"> <a href="/account_heads">Import CSV Data </a></div>


			   <div id="MainPad"  style=" height: 505px; overflow-y: scroll ">
			      <table  class="table table-striped m-b-none" >

				<thead >
				   <tr>
				      <th width="20px">ID</th>
				      <th>Group Name</th>
				      <th>Parent Group</th>
				      <th>Created By</th>
				      <th>Actions</th>
				      <th>Parent Group</th>
				      <th>Created By</th>
				      <th>Actions</th>
				      <th>Parent Group</th>
				      <th>Created By</th>
				      <th width="80px">Actions</th>
				   </tr>
				</thead>


				<tbody>
				   <tr style="height: 9px"></tr>
				   <tr >
				      <td>1000</td>
				      <td>Capital</td>
				      <td>Account Root Name</td>
				      <td>Ramesh</td>
				      <td>Capital</td>
				      <td>Account Root Chart</td>
				      <td>Ramesh</td>
				      <td>Capital</td>
				      <td>Account Root Chart</td>
				      <td>Ramesh</td>
				      <td>Ramesh</td>
				   </tr>

				   <tr>
				      <td>ID</td>
				      <td>Current Asset</td>
				      <td>Account Root Chart </td>
				      <td>Ramesh</td>
				      <td>Current Asset</td>
				      <td>Account Root Chart</td>
				      <td>Ramesh</td>
				      <td>Current Asset</td>
				      <td>Account Root Chart</td>
				      <td>Ramesh</td>
				      <td>Ramesh</td>
				   </tr>


				<tfoot>
				   <tr >

				   </tr>
				</tfoot>
			      </table>
			   </div>


			</div>

			<!-----------Backend Server site Data fetch showing  row column end---------------------->






			<!-------------Header-------Start------------------------Model ke andar Tab ----------------------------->

			<form id="visitorcoStumerfOrm">
			   <div class="modal" id="myvisitorcoStumerTab" style="z-index: 10000">
			      <div class="modal-body">
				<div class="modal-content" style=" background-color: #009999">



				   <!---Header---><div class="container-fluid" style="border: 0px #999999 solid"  >
				      <div class="row" style=" border-bottom: 0px #666666 solid; padding-top: 4px; background-color: #009999">

					<div class="col-sm-11">
					   <font style=" padding: 2px;  font-size: 13px;  font-family: Arial Unicode MS">Create Info-Ledger of Visitor- <b><font style="color: orange">PERSONAL</font></b> </font>
					</div>

					<div class="col-sm-1">
					   <button type="button" class="close closecroSSButton" data-dismiss="modal"><font style="background-color: white; padding: 0px 8px 0px 8px">&times;</font></button>
					</div>

				      </div>
				   </div>

				   <!-------------Header-------End-----------------------Model ke andar Tab ----------------------------->



				   <!-------------UNDER-------Start------------------------Model ke andar Tab ----------------------------->



				   <!---Middle--->

				   <div class="row col-sm-12 container-fluid" style="  margin: 0px; ">
				      <div class="row col-sm-11 container-fluid" style="height: 585px; margin: 0px; border: 0px gray solid">

					<!--Front Upside   -->
					<div class="row-cols-12" style=" height: 205px; margin: 0px -15px 0px -15px; width: 1175px; border: 0px solid #cccccc">

					   <div  style="display: inline-block; background-color: #ccffcc; width:584px; height: 143px; border: 1px gray dotted">




					   </div>

					   <div  style="display: inline-block; background-color:  #ffebeb; width:580px; height: 143px; border:1px gray dotted">




					   </div>



					</div>




					<!--Front Upside   -->
					<!---Middle to Under --->
					<ul  class="tab-warp con"  id="miniTab"   style=" z-index: 5000; margin: -251px -10px 0px -15px; width: 1172px; border: 0px  #cccccc solid">




					   <!-----------Tab Job 1 Start--------------------------------------------------------------------------------------------------------------------------------->

					   <li >
					      <input type="radio" id="tab-41" name="tabUnderModel" checked/>
					      <label for="tab-41"> Address </label>

					      <!-----------Backend Server Data send and save fetch showing  row column start---------------------->

					      ,<div class="tab-content"  style=" border: 0px gray solid; height: 392px; background-color: #ccffcc;" >

						<div class="TaBname" style=" margin-top: -4px; background-color:#ccffcc ;  border: 0px red solid">
						   <div  style=" height: 382px">

						      <div class="row-cols-sm-12" style="height: 125px; background-color: none">






						      </div>
						   </div>


						</div>

						<!-----------Backend Server Data send and save fetch showing  row column End---------------------->


					   </li>

					   <!-----------Tab Job 1 End--------------------------------------------------------------------------------------------------------------------------------->





					</ul>


					<!-------------UNDER-------END------------------------Model ke andar Tab ----------------------------->
					<!--Middle-end-->    </div>



				      <div class="row col-sm-1 container" style=" background-color: #d2fad2 ;margin: 0px; border: 1px #cccccc solid; height: 571px">









				      </div>


				   </div>



				</div>
			      </div>
			   </div>
			</form>
		      </li>


		      <!-------------Costumer Tab  End---------------ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt------>






		      <!-------------Vendor Tab  Start---------------ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt------>

		      <li>
			<input type="radio" id="tab-1" name="tab"/>
			<label for="tab-1"> <p tabindex="2">Vendor</p> </label>



			<!-----------Backend Server site Data fetch showing  row column start---------------------->

			,<div class="tab-content">

			   <div style="display: inline-block"><button type="button" id="myBtn1" data-toggle="modal" data-target="#myvisitorcoStumerTab"> New</button><div style="display: inline-block; width: 600px"></div><input type="search" placeholder="Search" style="height: 20px; width: 250px; padding-left: 5px; font-size: 12px"> <a href="/account_heads">Import CSV Data </a></div>


			   <div id="MainPad"  style=" height: 505px; overflow-y: scroll ">
			      <table  class="table table-striped m-b-none" >

				<thead >
				   <tr>
				      <th width="20px">ID</th>
				      <th>Group Name</th>
				      <th>Parent Group</th>
				      <th>Created By</th>
				      <th>Actions</th>
				      <th>Parent Group</th>
				      <th>Created By</th>
				      <th>Actions</th>
				      <th>Parent Group</th>
				      <th>Created By</th>
				      <th width="80px">Actions</th>
				   </tr>
				</thead>


				<tbody>
				   <tr style="height: 9px"></tr>
				   <tr >
				      <td>1000</td>
				      <td>Capital</td>
				      <td>Account Root Name</td>
				      <td>Ramesh</td>
				      <td>Capital</td>
				      <td>Account Root Chart</td>
				      <td>Ramesh</td>
				      <td>Capital</td>
				      <td>Account Root Chart</td>
				      <td>Ramesh</td>
				      <td>Ramesh</td>
				   </tr>



				<tfoot>
				   <tr >

				   </tr>
				</tfoot>
			      </table>
			   </div>


			</div>

			<!-----------Backend Server site Data fetch showing  row column end---------------------->






			<!-------------Header-------Start------------------------Model ke andar Tab ----------------------------->

			<form id="visitorveNdorfOrm">
			   <div class="modal" id="myvisitorveNdorTab" style="z-index: 10000">
			      <div class="modal-body">
				<div class="modal-content" style=" background-color: #009999">



				   <!---Header---><div class="container-fluid" style="border: 0px #999999 solid"  >
				      <div class="row" style=" border-bottom: 0px #666666 solid; padding-top: 4px; background-color: #009999">

					<div class="col-sm-11">
					   <font style=" padding: 2px;  font-size: 13px;  font-family: Arial Unicode MS">Create Info-Ledger of Visitor- <b><font style="color: orange">PERSONAL</font></b> </font>
					</div>

					<div class="col-sm-1">
					   <button type="button" class="close closecroSSButton" data-dismiss="modal"><font style="background-color: white; padding: 0px 8px 0px 8px">&times;</font></button>
					</div>

				      </div>
				   </div>

				   <!-------------Header-------End-----------------------Model ke andar Tab ----------------------------->



				   <!-------------UNDER-------Start------------------------Model ke andar Tab ----------------------------->



				   <!---Middle--->

				   <div class="row col-sm-12 container-fluid" style="  margin: 0px; ">
				      <div class="row col-sm-11 container-fluid" style="height: 585px; margin: 0px; border: 0px gray solid">

					<!--Front Upside   -->
					<div class="row-cols-12" style=" height: 205px; margin: 0px -15px 0px -15px; width: 1175px; border: 0px solid #cccccc">

					   <div  style="display: inline-block; background-color: #ccffcc; width:584px; height: 143px; border: 1px gray dotted">




					   </div>

					   <div  style="display: inline-block; background-color:  #ffebeb; width:580px; height: 143px; border:1px gray dotted">




					   </div>



					</div>




					<!--Front Upside   -->
					<!---Middle to Under --->
					<ul  class="tab-warp con"  id="miniTab"   style=" z-index: 5000; margin: -251px -10px 0px -15px; width: 1172px; border: 0px  #cccccc solid">




					   <!-----------Tab Job 1 Start--------------------------------------------------------------------------------------------------------------------------------->

					   <li >
					      <input type="radio" id="tab-41" name="tabUnderModel" checked/>
					      <label for="tab-41"> Address </label>

					      <!-----------Backend Server Data send and save fetch showing  row column start---------------------->

					      ,<div class="tab-content"  style=" border: 0px gray solid; height: 392px; background-color: #ccffcc;" >

						<div class="TaBname" style=" margin-top: -4px; background-color:#ccffcc ;  border: 0px red solid">
						   <div  style=" height: 382px">

						      <div class="row-cols-sm-12" style="height: 125px; background-color: none">






						      </div>
						   </div>


						</div>

						<!-----------Backend Server Data send and save fetch showing  row column End---------------------->


					   </li>

					   <!-----------Tab Job 1 End--------------------------------------------------------------------------------------------------------------------------------->





					</ul>


					<!-------------UNDER-------END------------------------Model ke andar Tab ----------------------------->
					<!--Middle-end-->    </div>



				      <div class="row col-sm-1 container" style=" background-color: #d2fad2 ;margin: 0px; border: 1px #cccccc solid; height: 571px">









				      </div>


				   </div>



				</div>
			      </div>
			   </div>
			</form>
		      </li>


		      <!-------------Vendor Tab  End---------------ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt------>














		   </ul>

		</div>


	      </div>

	      <!--***************************************Tab Wrap end***************************************************************************************************-->


	   </div>


	   <!--------------Visitor end-------middle column------------------------------------------------------>
























	   <!-------------- Action and Report start------------------------------>
	   <div   class="col-sm-1 reportDept text-left" style=" background-color: #1560bd; margin-left: 0px ; padding: 0px 2px 0px 1px; font-size: 10px; border-left: 1px white solid; letter-spacing: 2px;  color: white">



	      <ul>

		<li> Task  </li>

		<li>  Permission </li>


	      </ul>


	      <div class="col-sm-1 text-center"  style="border-left: 1px solid #1560bd; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 8px 2px 8px 12px">

		Report

	      </div>
	      <ul>



	      </ul>


	   </div>


	   <!--------------Action and Report End------------------------------>




	</div>
      </div>

   <spanle style="font-size:12px; color:  #666666">Copyright@ Opam-G Infocons Industries Ltd, Reg. Office- House No-108, Vill-Jalalpur, Post-Parmanandpur, Pin No-844507, Mahnar Road (R.S.) , Dist-Vaishali, Bihar, India  </span>

   <!------------------------------------------------------------------------------------->
   <script src="../../js/oPamGfunctionmy.js"></script>
   <script type="text/javascript" src="../../js/jquery.js"></script>
   <script type="text/javascript" src="../../js/popper.min.js"></script>
   <script type="text/javascript" src="../../js/bootstrap.js"></script>
</body>
</html>
