const URL = 'http://localhost:8080';
let username = '';

function userExists(){
    $.ajax({
        type: 'POST',
        url: URL+'/users/exists',
        contentType: "application/json",
        dataType: "json",
        data: username,
        success: function(data){
            if(data.exists == true)
            {
                $.mobile.changePage("#main-app");
                console.log(data)
            }
            else
            {
                $("#username-err").show();
                console.log(data)
            }
        }
    }).fail(function(err){
        $("#server-err").show();
    });
}

function addToQueue(){
    $.ajax({
        type: 'POST',
        url: URL+'/queue/add',
        contentType: "application/json",
        data: username,
        success: function(data){
            console.log("[ADD]",data)
        }
    });
}

function isOccupied(){
    $.ajax({
        type: 'GET',
        url: URL+'/queue/status',
        contentType: "application/json",
        dataType: "json",
        success: function(data){
            $('#is-occupied').append(data);
            console.log(data);
        }

    }).fail(function(err){
        console.log('[GET QUEUE]',err.responseText)
    })
}


$(document).on('pagebeforeshow', '#login-panel', function(){
    $("#server-err").hide();
    $("#username-err").hide();

    $("#login").click(function(){
        username = $('#username').val();
        userExists();
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

    isOccupied();

    $("#add-btn").click(function(){
        addToQueue();
        isOccupied();
    });

    $("#refresh-btn").click(function(){
        isOccupied();
    });

});