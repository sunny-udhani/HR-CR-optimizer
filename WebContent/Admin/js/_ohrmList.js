// handling table header click
$("table thead tr th.header").click(function(e) {
    var target = e.target;
    var currentTarget = e.currentTarget;
    // if click on url itself no need to programmaticlly click it.
    // sometimes even though target and currentTarget is not same condition evaluates true
    if (currentTarget === target) {
        $(currentTarget).children('a')[0].click();
    }
});

function ohrmList_init() {

    $('input[id^=ohrmList_chkSelectAll]').click(function() {
        
        var valueToSet = false;
        
        if ($(this).attr('checked') == 'checked') {
            valueToSet = true;
        }                            
        $(this).parents('.table').find('input[id^="ohrmList_chkSelectRecord_"]').attr('checked', valueToSet);
        
    });

    $('input[id^="ohrmList_chkSelectRecord_"]').click(function() {
        var selectorCheckboxes =  $(this).parents('.table').find('input[id^="ohrmList_chkSelectRecord_"]')
        var isAllChecked = (selectorCheckboxes.size() == selectorCheckboxes.filter(':checked').size());
         $(this).parents('.table').find('input[id="ohrmList_chkSelectAll"]').attr('checked', isAllChecked);
    });
    
    
    $("table.treetable").each(function(){
        var curTable = $(this);
       if(curTable.attr('id') != null){
        if(jQuery.data( document.getElementById(curTable.attr('id')),"check")){
        
        curTable.on('click',':checkbox[name*="chkSelectRow[]"]',function() {
             
             var $row = $(this).closest('tr');
             var td = $(this).parents('td').find('input');
             if (td.is(':checked')) {
                 var ids = new Array();
                 var id = $row.attr('data-tt-id');
                 ids.push(id);
                 var table = document.getElementById(curTable.attr('id'));
                    for (var i = 0, row; row = table.rows[i]; i++) {
                        if (ids.indexOf(row.getAttribute("data-tt-parent-id")) > -1) {
                            ids.push(row.getAttribute("data-tt-id"));
                            var chk = row.getElementsByTagName('input');
                            chk[0].checked = true;
                        }
                    }
             }
             
          });
        
    }
       }
    });
    
};


/**
 * Used in pagination links
 * TODO: Rename with a proper method once paging_links_js partial is replaced
 */
function submitPage(pageNumber) {
    var baseUrl = location.href;
    var urlSuffix = '';
    
    if (baseUrl.match(/index\.php\/\w{1,}$/)) {
        baseUrl += '/index/';
    }

    if (baseUrl.match(/pageNo\/\d{1,}/)) {
        baseUrl = baseUrl.replace(/pageNo\/\d{1,}/, 'pageNo/' + pageNumber);
    } else {
        urlSuffix = (baseUrl.match(/\/$/) ? '' : '/') + 'pageNo/' + pageNumber;
    }
    
    location.href = baseUrl + urlSuffix;
}
