<%--
    Document   : visitor
    Created on : Aug 28, 2020, 10:08:50 AM
    Author     : Ramesh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  <head>
    <title>G-ERP Account </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/bootstrap.css"/>
    <link rel="stylesheet" href="../../css/Mystyle.css"/>
    <link rel="stylesheet" href="../../icofont/icofont.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.4/css/buttons.dataTables.min.css"/>
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
    <script>
      function getFieldData(id) {
        var data = $('#' + id).val();
        return data;
      }
      function textWithSpace(data) {
        var re = /^[a-zA-Z ]+$/;
        return re.test(data);
      }
      function text(data) {
        var re = /^[a-zA-Z]+$/;
        return re.test(data);
      }
      function textWithNumber(data) {
        var re = /^[a-z0-9-]+$/i;
        return re.test(data);
      }
      function dob(data) {
        var re = /^\d{2}([./-])\d{2}\1\d{4}$/;
        fields["dob"] = re.test(data);
      }
      function number(data) {
        var pattern = /^\d+$/;
        return pattern.test(data);
      }
      function validateEmail(data) {
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(data);
      }
      function Contact_number(data) {
        var pattern = new RegExp("^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$");
        return pattern.test(data);
      }
      function validate(fields) {
        var finallyreturn = true;
        fname(getFieldData("fname"));
        lname(getFieldData("lname"));
        //                dob(getFieldData("dob"));
        filterPhone(getFieldData('mobile'));
        validateEmail(getFieldData('email'));
        ValidateUsername(getFieldData('username'));
        ValidatePassword(getFieldData('password'));
        confirm_password(getFieldData('password'), getFieldData('confirmpassword'));
        for (var key in fields) {
          if (fields.hasOwnProperty(key)) {
            console.log(key + "--" + fields[key]);
            if (fields[key] === false) {
              finallyreturn = false;
              $('.errormessage').text(key.toString().toUpperCase() + " is invalid");
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.errormessage').text(key.toString().toUpperCase() + " valid");

            }
          }
        }
        return finallyreturn;
      }
      function validateLevelForm() {
        var level_fields = {
          add_level_id: textWithNumber(getFieldData("add_level_id"))
        };

        var finallyreturn = true;
        for (var key in level_fields) {
          if (level_fields.hasOwnProperty(key)) {
            console.log(key + "--" + level_fields[key]);
            if (level_fields[key] === false) {
              finallyreturn = false;
              $('.level_form_errormessage').text("Field is invalid".toUpperCase());
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.level_form_errormessage').text("Field is valid ".toUpperCase());

            }
          }
        }
        return finallyreturn;
      }
      function validaterRootChartForm() {
        var level_fields = {
          add_leaf_id: text(getFieldData("add_leaf_id"))
        };

        var finallyreturn = true;
        for (var key in level_fields) {
          if (level_fields.hasOwnProperty(key)) {
            console.log(key + "--" + level_fields[key]);
            if (level_fields[key] === false) {
              finallyreturn = false;
              $('.leaf_form_errormessage').text("Field is invalid".toUpperCase());
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.leaf_form_errormessage').text("Field is valid ".toUpperCase());

            }
          }
        }
        return finallyreturn;
      }
      function validaterAddFields() {
        var level_fields = {
          field_name: text(getFieldData("field_name")),
          placeholder: text(getFieldData("placeholder"))
        };

        var finallyreturn = true;
        for (var key in level_fields) {
          if (level_fields.hasOwnProperty(key)) {
            console.log(key + "--" + level_fields[key]);
            if (level_fields[key] === false) {
              finallyreturn = false;
              $('.leaf_form_errormessage').text("Field is invalid".toUpperCase());
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.leaf_form_errormessage').text("Field is valid ".toUpperCase());

            }
          }
        }
        return finallyreturn;
      }
    </script>
    <style type="text/css">

      #table6_wrapper .dt-buttons{

        background-color: white;

      }
      #table6_filter{
        padding: 0px;
      }
      #table6_filter label{
        background-color: white;
        margin: 0px;
      }
      #table6{
        background-color: transparent;
      }
      #table6 tbody tr td{
        background-color: #003366;
      }

      /*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
      */
      /*
          Created on : Apr 25, 2020, 6:18:08 PM
          Author     : Ramesh
      */

      html {
        font-size: 70%;
        -webkit-tap-highlight-color: transparent;
      }

      tab-wrapDataTab {
        font-size: 70%;
        -webkit-tap-highlight-color: transparent;
      }

      warp-tab {
        font-size: 70%;
        -webkit-tap-highlight-color: transparent;
      }



      body, h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {
        font-family: 'Open Sans',"HelveticaNeue", "Helvetica Neue", Helvetica, Arial,sans-serif;
      }

      tbody {
        display: table-row-group;
        vertical-align: middle;
        border-color: inherit;
      }


      table {
        border-collapse: collapse;
        border-spacing: 0;
      }

      #MainPad table  {
        border-spacing: 0;
        background: inherit;
        border-collapse: collapse;
        word-wrap: normal;
        font-size: 15px;
      }

      .panel {
        border-color: #e3e8ed;
      }
      .panel {
        margin-bottom: 20px;
        background-color: #ffffff;
        border: 1px solid transparent;
        border-radius: 4px;
        -webkit-box-shadow: 0 1px 1px rgba(0,0,0,0.05);
        box-shadow: 0 1px 1px rgba(0,0,0,0.05);
      }
      article, aside, details, figcaption, figure, footer, header, hgroup, main, nav, section, summary {
        display: block;
      }

      .bg-focus {
        background: #ffffee !important;
      }

      element.style {
        margin: 0px -746.667px 0px 0px;
        width: 1066px;
        height: 330px;
      }

      .form-horizontal .form-group {
        margin-left: -15px;
        margin-right: -15px;
      }
      .form-group {
        margin-bottom: 15px;
      }
      *, *:before, *:after {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
      }
      user agent stylesheet
      div {
        display: block;
      }

      label {
        display: inline-block;
        margin-bottom: 0px;
        font-weight: bold;
      }

      label {
        cursor: default;
      }

      *, *:before, *:after {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
      }
      user agent stylesheet
      label {
        cursor: default;
      }
      .text-right {
        text-align: right;
      }

      .form-horizontal .control-label-required:after {
        content: "*";
        color: red;
      }

      element.style {
      }
      .col-xs-1, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9, .col-xs-10, .col-xs-11, .col-xs-12, .col-sm-1, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-sm-10, .col-sm-11, .col-sm-12, .col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-10, .col-md-11, .col-md-12, .col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-10, .col-lg-11, .col-lg-12 {
        position: relative;
        min-height: 1px;
        padding-left: 15px;
        padding-right: 15px;
      }

      *, *:before, *:after {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
      }
      user agent stylesheet
      div {
        display: block;
      }



      .tab-wrap table { border: 2px #003366 solid ;  margin-top: 5px; padding: 1px;  font-size: 10px; text-align: center; background-color: #5b5b4f}
      .tab-wrap th {margin: 0px; padding: 1px; border:1px  #004085 solid ; font-size: 10px;  }
      .tab-wrap tr { margin: 0px; padding: 1px; border:1px  #004085 solid ; font-size: 10px; color: white; letter-spacing: 1px   }
      .tab-wrap td {margin: 0px; padding: 1px;border:1px  #004085 solid ; font-size: 10px;}

      #SlNo {padding: 1px; width: 25px; height: 20px; background: #fdfdb2 ;font-size: 11px;color: white}
      #AddressType {padding: 1px;width: 80px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderAddress-Line {padding: 1px;width: 188px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderStreet-No {padding: 1px;width: 75px; height: 20px; background: #fdfdb2; font-size: 11px}
      #PlaceholderColony-Name {padding: 1px;width: 100px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderCity-Name {padding: 1px;width: 100px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderPin-Code {padding: 1px;width: 80px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderDistrict {padding: 1px;width: 100px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderState {padding: 1px;width: 100px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderCountry {padding: 1px;width: 95px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderGeo-Location {padding: 1px;width: 100px; height: 20px; background: #fdfdb2;font-size: 11px}
      #PlaceholderID-Proof {padding: 1px;width: 65px; height: 20px;background: #fdfdb2;font-size: 11px}

      #deleteRow {padding: 1px;width: 17px; height: 20px;background: #5b5b4f;font-size: 11px; color: white}
      #addRow {padding: 1px; height: 20px;background: #5b5b4f;font-size: 11px; color: white}



      #PlaceholderNameSearch {padding: 1px;width: 250px; height: 19px; background: #efefa6;font-size: 11px}
      #PlaceholderPhoto {padding: 1px;width: 100px; height: 19px; background: #ccffcc; font-size: 11px}




      *{padding: 0px; margin: 0px; font-family:Arial Unicode MS; box-sizing: border-box}
      /**[tabindex]:focus{ out: grey}*/

      ::-moz-selection {color: red; background: yellow}
      ::selection{color: red; background: yellow}


      /*.imageFitUser {width: 110px ; height: 88px}*/



      .A_row              {height: 25px; background-color: #1560bd; padding: 0px ; margin: 0px; letter-spacing: 1px}

      .A_row .socialicon         {padding-left: 10px; margin-right: 0px}

      .A_row .contact_info       {padding-left: 10px; margin-right: 0px}


      .companyinfo        {padding: 5px; margin-right: 0px; background-color: #ebf6f9; color: #004085}



      .menuVBusiness       {font-size: 14px; font-weight: 500; color: blue; font-weight: bold}
      .menuVBusiness       {list-style: none; margin-top: 0px; padding: 5px 2px 0px 6px}



      .menuV ul           {list-style: none; margin-top:5px; padding: 0px 0px 5px 7px; color: blue}
      .menuV ul li        {padding: 0px 2px 0px 12px; position: relative; text-align: right; cursor: pointer; border-bottom: 1px solid #BDC3C7; z-index: 1001; -webkit-transition: all 0.3s; -o-transition: all 0.3s; transition:  all 0.3s}
      .menuV ul li        {font-size: 13px; font-weight:500}
      .menuV ul li:hover  {border-bottom: 5px solid orangered}
      .menuV ul li:hover > ul {opacity: 1; visibility: visible}
      .menuV ul li a      {color: #061148; text-decoration: none}

      .menuV ul ul        {transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left:-15%; top:100%}


      .menuV ul ul li     {list-style: none; margin: 0px; padding: 3px 2px 3px 5px; text-align: left;z-index: 1001}
      .menuV ul ul li     {font-weight:normal}
      .menuV ul ul li     {background-color: white; width:185px}
      .menuV ul ul li:hover {background-color: orange; text-align: center;  border-bottom: 0px solid #F1C40F;z-index: 1002}

      .menuV ul ul li a   {color: #061148; text-decoration: none;z-index: 1003}


      .menuV ul ul ul    {transition: all 0.3s; opacity: 1; position: absolute;  visibility: hidden; left:-104%; top:-20%;z-index: 1005}

      .menuV ul ul ul li {list-style: none; margin: 0px; padding: 3px 2px 3px 5px;z-index: 1006}
      .menuV ul ul ul li {font-weight:normal}
      .menuV ul ul ul li {border-right: 1px #1560bd solid; background-color: white}
      .menuV ul ul ul li:hover { background-color: #ffa10a; text-align: center; border-bottom: 0px solid #F1C40F;z-index: 1007}

      .menuV ul ul ul li a   {color: #061148; text-decoration: none;z-index: 1008}


      .menuH ul    {margin: 0px ; padding: 2px; color: #061148}

      .menuH ul li    {padding: 4px 2px 1px 5px; text-align: left; letter-spacing: 1px ;font-size: 12px; font-stretch: semi-expanded; position: relative; width: 204px; border-left: 1px #1560bd solid; vertical-align: middle; background-color: white; cursor: pointer; border-bottom: 1px solid #BDC3C7}

      .menuH ul li:hover {background-color: orange; text-align: center;  border-bottom: 0px solid #F1C40F}
      .menuH ul li:hover > ul {opacity: 1; visibility: visible}

      .menuH ul ul    {list-style: none ;margin: 0px ; padding: 0; color: #660000}

      .menuH ul ul     { text-align: left; font-size: 12px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left:100%; top:0%}

      .menuH ul li a   {color: #061148; text-decoration: none}

      /* .menuH > ul > li::after{content: "+"; position: absolute; margin-left: 10%; color: #fff; font-size: 15px} */



      .menuI ul    {  margin-top: 0px; padding: 2px 2px 2px 2px;  color: #660000}

      .menuI ul li    {padding: 3px 2px 3px 2px; text-align: center; font-size: 12px; position: relative; width: 100px; border: 2px solid  #1560bd ; vertical-align: middle; background-color: white; cursor: pointer;}

      .menuI ul li:hover {background-color: orange; text-align: center; font-size: 13px; border-bottom: 0px solid #F1C40F}
      .menuI ul li:hover > ul {opacity: 1; visibility: visible}

      .menuI ul li a   {color: #660000; text-decoration: none}


      .GERP a   {color: white; text-decoration: none}
      .GERP    :hover {background: #00ff66; color: #004085; text-decoration: none}


      .menuK ul    {margin: 0px ; padding: 1px; color: white;  z-index:5100}

      .menuK ul li {padding: 1px 1px 1px 1px; text-align: center; letter-spacing: 1px ;font-size: 11px; font-stretch: semi-expanded; position: relative; width: 33px;  vertical-align: middle; cursor: pointer}

      .menuK ul li:hover {background-color: orange; text-align: center; color:#660000;  border-bottom: 0px solid #F1C40F}
      .menuK ul li:hover > ul {opacity: 1; visibility: visible}

      .menuK ul ul    {list-style: none ;margin: 0px ; padding: 0; color: #660000}

      .menuK ul ul     {  text-align: left; font-size: 12px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left: 0%; top:-102%}

      .menuK ul li ul{padding: 1px; text-align: left; color: #00ff66; width: 450px; border-bottom: 0px solid #F1C40F}


      .menuK ul a    {  text-align: left; font-size: 10px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left: 0%; top:-102%}


      .menuK1 ul    {margin: 0px ; padding:1px 1px 1px 1px; color: white}

      .menuK1 ul li {padding: 1px 1px 1px 1px; text-align: center; letter-spacing: 1px ;font-size: 11px; font-stretch: semi-expanded; position: relative; width: 34px;  vertical-align: middle; cursor: pointer}

      .menuK1 ul li:hover {background-color: orange; text-align: center; color:#660000;  border-bottom: 0px solid #F1C40F}
      .menuK1 ul li:hover > ul {opacity: 1; visibility: visible}

      .menuK1 ul ul    {list-style: none ;margin: 0px ; padding: 2px; color: #660000}

      .menuK1 ul ul     {  text-align: right; font-size: 12px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left: -775%; top:-102%}

      .menuK1 ul li ul{padding: 1px; text-align: right; color: #00ff66; width: 300px; border-bottom: 0px solid #F1C40F}


      .menuK1 ul a    {  text-align: right; font-size: 10px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left: 0%; top:-102%}




      /*<---ERP Dashboard Start----> */

      .dashboarderp ul    {list-style: none; margin: 0px ; padding: 0px; color: #061148; font-weight: normal; vertical-align: middle; border-left: 1px solid  #0066ff; z-index: 1000}

      .dashboarderp ul li    {padding: 3px 2px 3px 5px; text-align: left;  letter-spacing: 1px ;font-size: 12px;  font-stretch: semi-expanded; position: relative;  vertical-align:middle;  background-color: white; cursor: pointer; border: 1px solid #BDC3C7}

      .dashboarderp ul a   {color: #061148; text-decoration: none}


      .dashboarderp ul li:hover {background-color: orange;color: #061148; text-align: center;  border-bottom: 1px solid #F1C40F; line-height: 14px}
      .dashboarderp ul li:hover > ul {opacity: 1; visibility: visible}

      .dashboarderp ul ul    {width: 204px; list-style: none ;margin: 0px ; padding: 0px; color: #061148;  border-left: 1px solid  #0066ff}

      .dashboarderp ul ul     {  text-align: left; font-size: 12px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left:102%; top:-5%}

      .dashboarderp ul li a   {color: #061148; text-decoration: none}

      /* <---End Dashboard Start----> */

      /*<---Emplyee   Dashboard Start----> */

      .dashboardemp ul    {list-style: none; margin: 0px ; padding: 0px; color: #061148; font-weight: normal; vertical-align: middle; border-left: 1px solid  #0066ff; z-index: 1000}

      .dashboardemp ul li    {padding: 4px 2px 4px 6px; text-align: left;  letter-spacing: 1px ;font-size: 12px;  font-stretch: semi-expanded; position: relative;  vertical-align:middle;  background-color: white; cursor: pointer; border: 1px solid #BDC3C7}

      .dashboardemp ul li:hover {background-color: orange;color: #061148; text-align: center;  border-bottom: 1px solid #F1C40F; line-height: 14px}
      .dashboardemp ul li:hover > ul {opacity: 1; visibility: visible}

      .dashboardemp ul ul    {width: 204px; list-style: none ;margin: 0px ; padding: 0px; color: #061148;  border-left: 1px solid  #0066ff}

      .dashboardemp ul ul     {  text-align: left; font-size: 12px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; left:102%; top:-5%}

      .dashboardemp ul li a   {color: #061148; text-decoration: none}


      /* <---Employee End Dashboard Start----> */

      /*<---ERP Dashboard Start----> */

      .reportDept ul    {list-style: none; margin: 0px ; padding: 0px; color: #061148; font-weight: normal; vertical-align: middle; border-right: 1px solid  #0066ff; z-index: 1000}

      .reportDept ul li    {padding: 3px 2px 3px 5px; text-align: left;  letter-spacing: 1px ;font-size: 12px;  font-stretch: semi-expanded; position: relative;  vertical-align:middle;  background-color: white; cursor: pointer; border: 1px solid #BDC3C7}

      .reportDept ul li:hover {background-color: orange;color: #061148; text-align: center;  border-bottom: 1px solid #F1C40F; line-height: 14px}
      .reportDept ul li:hover > ul {opacity: 1; visibility: visible}

      .reportDept ul ul    {width: 150px; list-style: none ;margin: 0px ; padding: 0; color: #061148;  border-right: 1px solid  #0066ff}

      .reportDept ul ul     { text-align: left; font-size: 12px; transition: all 0.3s; opacity: 0; position: absolute;  visibility: hidden; right:101%; top:-5%}

      .reportDept ul li a   {color: #061148; text-decoration: none}





      /* <---End Dashboard Start----> */

      .tab-wrapDataTab {
        width: 100%; list-style: none; text-align: left; padding: 0; margin: 0 0 0 0px;
        position: relative;
      }


      .tab-wrapDataTab input[type="radio"]{
        position: absolute; top:-9999px; left: -9999px;
      }

      .tab-wrapDataTab li {
        float: left;
        display: block;
      }

      .tab-wrapDataTab label {
        text-align: center;  background: #19bb2e; letter-spacing: 1px;  font-size: 11px; color: white; text-decoration: none; display: block; border-radius: 2px 2px 0 0;padding: 2px 10px 2px 10px; margin-right: 3px; cursor: pointer;
      }

      .tab-wrapDataTab .tab-content{
        background: whitesmoke; color: white;  width: 100%; height: 540px; border-radius: 0 3px 3px 3px; position: absolute; top: 22px; left: 0px; padding: 4px; margin: 0px; display: none}

      .tab-wrapDataTab [id^="tab"]:checked + label {background: whitesmoke; color: #19bb2e}

      .tab-wrapDataTab [id^="tab"]:checked ~ .tab-content {display:block}

      /*<-----------MiniTab start------->*/

      .tab-wrap  {
        width: 100%; list-style: none; text-align: left; padding: 0; margin: 0 0 0 0px;
        position: relative;
      }


      .tab-wrap  input[type="radio"]{
        position: absolute; top:-9999px; left: -9999px;
      }

      .tab-wrap   li {
        float: left;
        display: block;
      }

      .tab-wrap   label {
        text-align: center; width: 180px ; letter-spacing: 1px; background: #36eaa2; font-size: 15px; color: #061148;font-family:Arial Unicode MS; text-decoration: none; display: block; border-radius: 2px 2px 0 0;padding: 10px 1px 5px 1px; margin: 3px; cursor: pointer;
      }

      .tab-wrap   table tr td {
        font-size: 11px ; padding: 4px 2px 4px 2px;
      }

      .tab-wrap  .tab-content{
        font-size: 11px; background: #003366; color: white; width: 100%; height: 536px; border-radius: 0 3px 3px 3px; position: absolute; top: 35px; left: 0px; padding: 4px; margin: 0px; display: none}


      .tab-wrap   [id^="tab"]:checked + label {background: #003366; color: #ffffff}


      .tab-wrap  [id^="tab"]:checked ~ .tab-content {display:block}


      /*<-----------MiniTab start------->*/


      .tab-wrap #miniTab {
        background-color: #009999;  width: 100%; list-style: none; text-align: left; padding: 0; margin: 0 0 0 0px;
        position: relative;
      }


      .tab-wrap #miniTab input[type="radio"]{
        position: absolute; top:-9999px; left: -9999px;
      }

      .tab-wrap #miniTab  li {
        float: left;
        display: block;
      }
      .tab-wrap #miniTab label {
        text-align: center; width: auto; letter-spacing: 1px; background: #36eaa2; font-size: 15px; color: #061148;font-family:Arial Unicode MS; text-decoration: none; display: block; border-radius: 2px 2px 0 0;padding: 10px 10px 10px 10px; margin: 3px; cursor: pointer;
      }

      .tab-wrap #miniTab label .tab-content {
        background: #003366; color: #003366; width: 100%; height: 540px; border-radius: 0 3px 3px 3px; position: absolute; top: 35px; left: 0px; padding: 4px; margin: 0px; display: none}


      .tab-wrap #miniTab [id^="tab"]:checked + label {background: #ccffcc; color: orangered }

      .tab-wrap #miniTab [id^="tab"]:checked ~ .tab-content {display:block}

      /*<-----------MiniTab End------->*/



      /*<-----------Root SubTab start------->*/



      /*-----------Tab Page Name-------G-Erp---------start------------->*/


      /*-----------Tab Inside Page Name-------G-ERp---------End------------->*/


      /*-----------Tab Page Name-------G-ERp---------End------------->*/
      /*-----------Tab Page Name-------button---------start------------->*/

      #myBtn1 { padding: 7px; border-radius: 10px; background: #004085; width:121px; font-size: 12px; color: #BDC3C7 ;font-family:Arial Unicode MS}

      #checkBox {font-size: 15px; color:  #061148; width: 120px; padding: 8px 2px 8px 2px; }

      .closecroSSButton { font-size: 18px; color: black; text-align: right; padding: 0px}

      #Uname {width: 210px; background-color: #000000 ; color: white; font-size: 11px; padding: 1px; border:none}

      #Vname {width: 125px; background-color: black; color: white; padding: 1px 3px 1px 3px; border:none}


      /*------------------Clear Field data Button Start--------------------------------------*/

      input[type=button] { padding: 3px 15px 3px 15px; font-size: 13px; letter-spacing: 2px; background-color: #198d8d; color: white}

      #usNameF {padding: 5px 10px 0px 20px; border:0px #007bff solid; width: 180px; font-size:12px; color: #000000}
      #usName {padding: 5px 10px 0px 20px; border:0px #007bff solid; width: 350px; font-size:12px; color: white}
      #usNameG{font-size: 10px; color:black; margin-top: 8px}

      /*------------------Clear Field data Button End--------------------------------------*/



      #VisitoR_taB1GFG_EnteRButton {margin-right: 5px; padding: 10px 40px 10px 40px; font-size: 15px; letter-spacing: 2px;  background-color: #198d8d; color: white }



      #Visitor_taB2GFG_EnteRButton {margin-right: 5px; padding: 10px 40px 10px 40px; font-size: 15px; letter-spacing: 2px;  background-color: #198d8d; color: white }



      #Visitor_taB3GFG_EnteRButton {margin-right: 5px; padding: 10px 40px 10px 40px; font-size: 15px; letter-spacing: 2px;  background-color: #198d8d; color: white }



      #Visitor_taB4GFG_EnteRButton {margin-right: 5px; padding: 10px 40px 10px 40px; font-size: 15px; letter-spacing: 2px;  background-color: #198d8d; color: white }



      #Visitor_taB5GFG_EnteRButton {margin-right: 5px; padding: 10px 40px 10px 40px; font-size: 15px; letter-spacing: 2px;  background-color: #198d8d; color: white }



      #Visitor_taB6GFG_EnteRButton {margin-right: 0px; padding: 3px 22px 3px 22px; font-size: 13px; letter-spacing: 2px;  background-color: #198d8d; color: white }






      /*-----------Tab Page Name-------Button---------End------------->*/









    </style>
  </head>
  <body>

    <%@include file="../common/header.jsp"%>
    <div id="myCompHeaderhideShow" class= "container-fluid" style="display: none; border-bottom: 0px  solid #1560bd; padding: 1px; margin: 0px; color: #004085">
      <div class=row style="border-bottom: 0px #000066 solid  ;padding: 0px; margin: 0px; height: 60px">
        <div class="col-sm-1 imageFitUser text-center" style="padding: 0px ; border-left: 1px #0056b3 solid; border-right: 1px #bbbbff solid; max-height: 88px; max-width: 112px">
          <a href="#" ><img src="image/Logo.png" alt=""/> </a>
        </div>
        <div class="col-sm-4 text-justify " style=" border: 0px solid #1560bd; font-size: 11px; letter-spacing: 1.25px; line-height: 12px">
          <b>Opam-G Infocons Industries Ltd.</b>
          <br>
          CIN- U2456666BR201778999
          <br>
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

    <div class= "container-fluid">
      <div class="row" style="border-top: 1px #000099 solid">
        <div class="col-sm-1 text-center"  style="border-right: 1px #007bff solid; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">
          Info-Ledger
        </div>
        <div class="col-sm-10 text-center"  style="border: 0px #000 solid  ; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">
          <div class="row">
            <div class="col-sm-1">
            </div>
            <div class="col-sm-10">
              <span style="background-color: red; padding: 2px 20px 2px 20px; color: white">
                Info- Ledger of Visitor
              </span>
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

    <div class="container-fluid text-center" style=" font-size: 13px; background-color: white; color: white; font-weight: 500; border-top: 1px #1560bd solid;  border-shadow:50px 10px">
      <div class="row">
        <!----------------------------Left Side bar----------->
        <div class="col-sm-1 dashboarderp text-left" style=" background-color: #1560bd; margin-left: 0px ; padding: 0px 1px 0px 2px; font-size: 10px; letter-spacing: 2px;  color: white">

          <%@include file="common/RootSidebar.jsp" %>
          <!----------------------------Left Side bar----------->
        </div>
        <div   class="col-sm-10  text-left" style=" border:0px #00ff66 solid; background-color: whitesmoke; color: #99ff99 ; margin-top: 0px ; padding: 1px; font-size: 10px; letter-spacing: 2px;  color: white; line-height: 12px">
          <!--******************************************Tab wrap*********************************************************************************************-->
          <!------------Graph Data Sheet start---------->
          <div id="myGraphhideShow" class="row" style="display: block">
            <div  class="text-center" style=" background-color: #fcfcc6;border: 0px  #0056b3 solid; color: #061148 ; height: 150px">
              Graph Input
            </div>
          </div>
          <div class="row" style="display: block">
            <div style=" background: #061148;  margin: 0px 0px 0px 0px; padding: 2px; height: 577px">
              <span class="text-danger bg-white">
                <%                  if (request.getParameter("LevelException") != null) {
                    out.print("Error: " + request.getParameter("LevelException"));
                  }
                %>
              </span>
              <span class="text-danger bg-white">
                <%
                  if (request.getParameter("LevelMessage") != null) {
                    out.print("Message: " + request.getParameter("LevelMessage"));
                  }
                %>
              </span>

              <ul class="tab-wrap DataTab" style="">
                <!-------------Level-1  Start--------------------->
                <c:set var="checked" value="checked"></c:set>
                <c:forEach items="${LevelService.FindLevelByMain(MainService.findById(param.id))}" var="level" varStatus="i">
                  <c:set var="lastlevel" value="${level}" scope="page"></c:set>
                    <li>
                    <c:if test="${not empty sessionScope['active_level']}">
                      <c:set var="checked" value=""></c:set>
                      <c:if test="${sessionScope['active_level'] == i.index}" >
                        <c:set var="checked" value="checked"></c:set>
                      </c:if>
                    </c:if>
                    <input type="radio" id="tab-${i.index}" ${checked} onclick="changeLevel(${i.index})" name="tab"/>
                    <label for="tab-${i.index}"> <p tabindex="${i.index}">${level.name}</p> </label>
                    <!-----------Backend Server site Data fetch showing  row column start---------------------->
                    ,<div class="tab-content show">
                      <div style="display: inline-block">
                        <button type="button" id="myBtn1" data-toggle="modal" data-target="#myvisitorcoStumerTab"> New</button>
                      </div>
                      <form id="visitorcoStumerfOrm">
                        <div class="modal" id="myvisitorcoStumerTab" style="">
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
                              <div class="row col-sm-12 container-fluid" style="  margin: 0px; ">
                                <div class="row col-sm-11 container-fluid" style="height: 585px; margin: 0px; border: 0px gray solid">
                                  <!--Front Upside   -->
                                  <div class="row-cols-12" style=" height: 205px;overflow: scroll; margin: 0px -15px 0px -15px; width: 1175px; border: 0px solid #cccccc">
                                    <div  style="display:block; background-color: #ccffcc; border: 1px gray dotted">
                                      <div  style="letter-spacing: 1px; margin-top: 5px">
                                        <section class="panel">
                                          <div class="panel-body" style="color:black;">
                                            <!-------------------------------------------------------------------add form------------------------------------->
                                            <c:if test="${FormService.findByLevel(level).size()<1}">
                                              <button id="addformbtn" type="button" class="btn btn-success btn-sm" style="float: right;" data-toggle="modal" data-target="#addform${level.id}">&plus;Add form</button>
                                            </c:if>

                                            <!-- Modal -->
                                            <div id="addform${level.id}" class="modal fade" role="dialog">
                                              <div class="modal-dialog">
                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                  <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Add new form</h4>
                                                  </div>
                                                  <div class="modal-body">
                                                    <form onsubmit="validateLevelForm()" action="../leaf/level-form/create" method="POST" enctype="multipart/form-data">
                                                      <div class="level_form_errormessage"></div>

                                                      <input id="level_id" type="hidden" value="${level.id}" name="level">
                                                      <div class="form-group">
                                                        <input onblur="" type="text" class="form-control"  placeholder="Add form name">
                                                        <input type="hidden" class="form-control" name="action" value="xyz">
                                                        <input type="hidden" class="form-control" name="method" value="post">
                                                      </div>
                                                      <button type="submit" class="btn btn-success">Submit</button>
                                                    </form>
                                                  </div>
                                                  <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                  </div>
                                                </div>

                                              </div>
                                            </div>
                                            <!-------------------------------------------------------------------end add form------------------------------------->

                                            <c:forEach items="${FormService.findByLevel(level)}" var="form" varStatus="formindex">
                                              <script>
                                                $(document).ready(function () {
                                                  $('#addform${level.id}').hide();
                                                });
                                              </script>
                                              <form method="POST" action="../leaf/level-form-data/create" style="border: 2px solid #19BB2E; border-radius: 2px; padding: 10px;">
                                                <div class="row form-group">
                                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="field" varStatus="">
                                                    <div class="col-lg-3 mb-2">
                                                      <input class="bg-focus form-control" required name="${field.name}" type="${field.type}" value="" placeholder="${field.placeholder}" autocomplete="off">
                                                    </div>
                                                  </c:forEach>
                                                </div>
                                                <input type="hidden" name="levelFormId" value="${form.id}">
                                                <div class="row form-group">
                                                  <div class="col-lg-3">
                                                    <input type="submit" value="Save" class="btn btn-block btn-outline-success">
                                                  </div>
                                                </div>

                                                <button style="margin-bottom: 50px;" type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
                                                  &plus; Add field
                                                </button>
                                              </form>

                                              <div style="z-index: 6000;" class="modal" id="${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
                                                <div class="modal-dialog">
                                                  <div class="modal-content">
                                                    <div class="modal-header">
                                                      <h4 class="modal-title">Add fields</h4>
                                                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    </div>
                                                    <div class="modal-body">
                                                      <form action="../leaf/level-form-field/create"  method="POST" enctype="multipart/form-data">
                                                        <input type="hidden" value="${form.id}" name="levelForm">
                                                        <div class="form-group">
                                                          <span class="text-success" for="chart_id">Select input type</span>
                                                          <select name="type" id="chart_id" class="form-control">
                                                            <option selected value="text">Text</option>
                                                            <option selected value="date">Date</option>
                                                            <option selected value="number">Number</option>
                                                          </select>
                                                        </div>
                                                        <div class="form-group">
                                                          <span class="text-success" for="chart_id">Set field name</span>
                                                          <input  required type="text" id="field_name" class="form-control" name="name">
                                                        </div>
                                                        <div class="form-group">
                                                          <span class="text-success" for="chart_id">Set placeholder</span>
                                                          <input required id="placeholder" type="text" class="form-control" name="placeholder">
                                                        </div>
                                                        <button type="submit" class="btn btn-success">Submit</button>
                                                      </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                      <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                                    </div>

                                                  </div>
                                                </div>
                                              </div>
                                            </div>
                                          </section>
                                        </div>
                                      </div>

                                    </div>
                                    <div class="row">
                                      <div class="row">

                                      </div>
                                    </div>
                                    <ul  class="tab-warp con"  id="miniTab"   style=" z-index: 5000; margin: -251px -10px 0px -15px; width: 1172px; border: 0px  #cccccc solid">
                                      <li >
                                        <input type="radio" id="tab-41" name="tabUnderModel" checked/>
                                        <label for="tab-41"> Address </label>
                                        <!-----------Backend Server Data send and save fetch showing  row column start---------------------->
                                        ,<div class="tab-content tab-content1"  style=" border: 0px gray solid; height: 392px; background-color: #ccffcc;" >

                                          <div class="TaBname" style=" margin-top: -4px; background-color:#ccffcc ;  border: 0px red solid">
                                            <div  style=" height: 382px">

                                              <div class="row-cols-sm-12" style="height: 125px; background-color: none">
                                              </div>
                                            </div>
                                          </div>
                                      </li>
                                    </ul>
                                  </div>
                                  <div class="row col-sm-1 container" style=" background-color: #d2fad2 ;margin: 0px; border: 1px #cccccc solid; height: 571px">
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </form>


                        <div>
                          <table id="table${level.id}" class="display nowrap" style="width:100%;color: black;" >
                            <thead>
                              <tr>
                                <th>ID</th>
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                  <th>
                                    ${allField.name}
                                  </th>
                                </c:forEach>
                                <th>Parent level</th>
                                <th>Parent Chart</th>
                                <th>Action</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach items="${FormDataService.getRepository().findByLevelForm(form)}" var="row" varStatus="rindex">
                                <tr>
                                  <td>${row.id}</td>
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                    <td>
                                      ${FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name)}
                                    </td>
                                  </c:forEach>
                                  <td>${LevelService.findOneById(level.level_id).getName()}</td>
                                  <td>${row.levelForm.level.chart.name}</td>
                                  <td><a href="../leaf/level-form-data/delete/?id=${row.id}" class="btn btn-danger">Delete</a></td>
                                </tr>
                              </c:forEach>
                            </tbody>
                            <tfoot>
                              <tr>
                                <th>ID</th>
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                  <th>
                                    ${allField.name}
                                  </th>
                                </c:forEach>
                                <th>Parent level</th>
                                <th>Parent Chart</th>
                                <th>Action</th>
                              </tr>
                            </tfoot>
                          </table>
                          <script>
                            $(document).ready(function () {
                              $('#table${level.id}').DataTable({
                                dom: 'Bfrtip',
                                buttons: [
                                  'copy', 'csv', 'excel', 'pdf', 'print'
                                ]
                              });
                            });
                          </script>
                        </div>
                      </c:forEach>
                    </div>
                    <!-----------Backend Server site Data fetch showing  row column end---------------------->
                  </li>
                  <c:if test="${i.index ge 0}">
                    <c:set var="checked" value="unchecked"></c:set>
                  </c:if>
                </c:forEach>
                <!-------------------------------------------------------------add level ---------------------------------------------------------------->
                <li accesskey="data-toggle="modal" data-target="#addlevel"">
		  <label>
                    &plus; Add level
                  </label>
                  <!-- The Modal -->
                  <div id="addlevel" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                      <!-- Modal content-->
                      <div class="modal-content">
                        <div class="modal-header">
                          <h4 class="modal-title">Create new level</h4>

                          <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                          <form action="../leaf/level/create" onsubmit="return validateLevelForm()" method="POST" enctype="multipart/form-data">

                            <div class="form-group">
                              <div class="level_form_errormessage text-danger"></div>
                              <span>Name</span>
                              <div><input onblur="validateLevelForm()" type="text" id="add_level_id" name="name" class="form-control"></div>
                            </div>
                            <div class="form-group">
                              <input name="chart" type="hidden" value="${param['id']}">
                            </div>
                            <div class="form-group">
                              <input type="hidden" name="level_id" value="${lastlevel eq  null?0:lastlevel.id}">
                            </div>
                            <button type="submit" class="btn btn-success">Submit</button>
                          </form>
                        </div>
                        <div class="modal-footer">
                          <!--<button type="button" class="btn btn-default" data-dismiss="modal">CloSSSse</button>-->
                        </div>
                      </div>

                    </div>
                  </div>
                  <script>
//                    $(document).ready(function () {
//                      $('#chart_id').on('change', function (e) {
//                        var optionSelected = $("option:selected", this);
//                        var valueSelected = this.value;
//                        setData(valueSelected);
//                      });
//
//
//                    });
//                    function setData(id) {
//                      $.post("../settings/getlevels/" + id,
//                              {
//                                id: id
//                              },
//                              function (obj, status) {
//                                var obj = JSON.parse(JSON.stringify(obj));
//                                $('#level_id').empty();
//                                for (var i = 0; i < obj.length; i++) {
//                                  $('#level_id').append($('<option>', {value: obj[i].id, text: obj[i].name}));
//                                }
//                              });
//                    }
                  </script>
                </li>
                <!----------------------------------------------------------------------------------------end add level ----------------------------------------->

              </ul>
            </div>
          </div>
          <!--***************************************Tab Wrap end***************************************************************************************************-->
        </div>
        <div class="col-sm-1">

        </div>
      </div>
    </div>
    <div class="footer">
      <div class="container text-center">

        <span style="font-size:11px; color:  #666666">Copyright@ Opam-G Infocons Industries Ltd, Reg. Office- House No-108, Vill-Jalalpur, Post-Parmanandpur, Pin No-844507, Mahnar Road (R.S.) , Dist-Vaishali, Bihar, India  </span>
        <a href="../leaf/settings">Settings</a>
        <!------------------------------------------------------------------------------------->
        <script>
          $(document).ready(function () {
            $('#example').DataTable({
              dom: 'Bfrtip',
              buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
              ]
            });
          });
        </script>
        <script>
          function changeLevel(id) {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
              if (this.readyState == 4 && this.status == 200) {

              }
            };
            xhttp.open("GET", "../leaf/level/changeLevel?id=" + id, true);
            xhttp.send();
          }
        </script>
      </div>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
    <script src="../../js/oPamGfunctionmy.js"></script>
    <script type="text/javascript" src="../../js/popper.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.js"></script>
  </body>
  </