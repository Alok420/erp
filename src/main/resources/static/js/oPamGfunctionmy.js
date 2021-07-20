/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//----------Company Header Hide & Show start------->             
           
 function myHeadeRFunction() {
  var x = document.getElementById("myCompHeaderhideShow");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

//----------Company Header Hide & Show End-------> 



//----------Company Graph Hide & Show start------->         
   
  function myGraphFunction() {
  var x = document.getElementById("myGraphhideShow");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
//----------Company Graph Hide & Show End-------> 



//----------Form Clear input feild start------->  

function cleaRperSonalButton() {
  document.getElementById("perSonalfOrm").reset();
}

function cleaRempLoyeeButton() {
  document.getElementById("empLoyeefOrm").reset();
}

function cleaRvenDorButton() {
  document.getElementById("venDorfOrm").reset();
}

function cleaRcusTomerButton() {
  document.getElementById("cusTomerfOrm").reset();
}

function cleaRgovTofficerButton() {
  document.getElementById("govTofficerfOrm").reset();
}

function cleaRviPButton() {
  document.getElementById("viPfOrm").reset();
}

//----------Form Clear input feild end------->




////---------Add new row in Table1 start------------//
//
//jQuery(document).delegate('.add-record', 'click', function(e) {
//     e.preventDefault();    
//     var content = jQuery('#sample_table tr'),
//     size = jQuery('#tbl_posts >tbody >tr').length + 1,
//     element = null,    
//     element = content.clone();
//     element.attr('id', 'rec-1'+size);
//     element.find('.delete-record').attr('data-id', size);
//     element.appendTo('#tbl_posts_body');
//     element.find('.sn').html(size);
//    });
//    
//   jQuery(document).delegate('.delete-record', 'click', function(e) {
//     e.preventDefault();    
//     var didConfirm = confirm("Are you sure You want to delete");
//     if (didConfirm == true) {
//      var id = jQuery(this).attr('data-id');
//      var targetDiv = jQuery(this).attr('targetDiv');
//      jQuery('#rec-1' + id).remove();
//      
//    //regnerate index number on table
//    $('#tbl_posts_body tr').each(function(index) {
//      //alert(index);
//      $(this).find('span.sn').html(index+1);
//    });
//    return true;
//  } else {
//    return false;
//  }
//   //regnerate index number on table
//    
//});
////---------Add new row Table End------------//
