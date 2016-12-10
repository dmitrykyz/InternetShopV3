<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.11.2016
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internet Shop</title>
    <link href="css/bootstrap.css" rel="stylesheet">

    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#AjaxButton').click(function(){
                var someText = $('#someText').val();
                $.ajax({
                    type:'POST',
                    data: {
                        someText : someText,
                        command: 'ajaxcommand'},
                    url: 'controller',
                    success: function(result){
//                        $(document).val(result);
//                        $('#someTextRezult').val(result);
                        $('#someTextRezult').val(someText + " Add text");
                    }
                })
            })
        })
    </script>
</head>
<body>


<form name="signupForm" method="POST" action="controller">
    <h3>Enter Button</h3>
    <input type="hidden" name="command" value="ajaxcommand" />
    SomeText:<br/> <input type="text" name="someText" id="someText" value="" />
    SomeTextRezult:<br/> <input type="text" id="someTextRezult" name="someTextRezult" value=""/>
    <input class="btn btn-default" type="button" value="AjaxButton" id="AjaxButton"/>
</form><hr/>

<div class="container">
    <div class="row">
        <div class="span12">
            <div class="" id="loginModal">
                <div class="modal-header">
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#infoModal">?</button>
                    <div class="modal fade" id="infoModal" tabindex="-1" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" type="button" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Info about Internet Shop</h4>
                                </div>
                                <div class="modal-body">In our shop your can buy any product. Welcom!</div>
                                <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Close</button> </div>
                            </div>
                        </div>
                    </div>
                    <h3>Hellow to Internet Shop!</h3>
                </div>
                <div class="alert-danger" role="alert">
                    <br/>
                    ${errorLoginPassMessage}
                    <br/>
                    ${wrongAction}
                    <br/>
                    ${nullPage}
                    <br/>
                </div>
                <div class="modal-body">
                    <div class="well">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#loginpanel" data-toggle="tab">Login</a></li>
                            <li><a href="#create" data-toggle="tab">Create Account</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane active in" id="loginpanel">
                                <form name="loginForm" method="POST" action="controller">
                                    <input type="hidden" name="command" value="login" />
                                    <fieldset>
                                        <div id="legend">
                                            <legend class="">Login</legend>
                                        </div>
                                        <div class="control-group">
                                            <!-- Username -->
                                            <label class="control-label"  for="login">Username</label>
                                            <div class="controls">
                                                <input type="text" id="login" name="login" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <!-- Password-->
                                            <label class="control-label" for="password">Password</label>
                                            <div class="controls">
                                                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>


                                        <div class="control-group">
                                            <!-- Button -->
                                            <div class="controls">
                                                <button class="btn btn-success">Login</button>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="create">
                                <form name="signupForm" method="POST" action="controller">
                                    <h3>Enter your authorization parameters</h3>
                                    <br/>
                                    <input type="hidden" name="command" value="addnewclient" />
                                    Login:<br/> <input type="text" name="login" value=""/>
                                    <br/>
                                    Password:<br/> <input type="password" name="password" value=""/>
                                    <br/>
                                    FirstName:<br/> <input type="text" name="firstname" value=""/>
                                    <br/>
                                    LastName:<br/> <input type="text" name="laststname" value=""/>
                                    <br/>
                                    Summ on Credit card:<br/> <input type="number" name="summoncreditcard" value=""/>
                                    <br/>
                                    <br/>
                                    <input class="btn btn-default" type="submit" value="Approve"/>
                                </form><hr/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
