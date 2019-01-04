const URL = '';

$(document).on('pagebeforeshow', '#login-panel', function(){
    $("#server-err").hide();
    $("#username-err").hide();

    $("#login").click(function(){
        $.ajax({
            type: 'POST',
            url: URL+'/users/exists',
            contentType: "application/json",
            dataType: "json",
            data: {
                username: encodeURIComponent($("#username").val())
            },
            success:function(data){
                if(data == "OK")
                {
                    $("#login-panel").hide();
                    $("#main-app").append("<h1>You are logged in</h1>");
                }
                else
                {
                    $("#username-err").show();
                }
            }
        }).fail(function(){
            $("#server-err").show();
            $.mobile.changePage("#main-app");

        });
    });

    $("#logout").click(function() {
        $("form")[0].reset();
        $("#login-panel").show();
        $("#main-app").hide();
        $("#server-err").hide();
        $("#username-err").hide();  
    });
});

$(document).on('pagebeforeshow', '#main-app', function(){
    
    $.ajax({
        type: 'GET',
        url: URL+'/queue/all',
        contentType: "application/json",
        dataType: "json",
        success: function(data){
            $('#is-empty').append(data);
            console.log(data);
        }

    }).fail(function(){
        console.log('[GET QUEUE] err')
    })

    $("#add-btn").click(function(){
        $.ajax({
            type: 'POST',
            url: URL+'/queue/add',
            contentType: "application/json",
            dataType: "json",
            data: {
                username: encodeURIComponent($("#username").val())
            },
            success:function(data){
                if(data == "OK")
                {
                    console.log(data);
                }
                else
                {
                    
                }
            }
        }).fail(function(){
            console.log('[ADD TO QUEUE] err')            
        });
    });

});