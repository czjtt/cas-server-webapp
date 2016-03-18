/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

$(document).ready(function(){
    //focus username field
    $("input:visible:enabled:first").focus();
    //flash error box
    $('#msg.errors').animate({ backgroundColor: 'rgb(187,0,0)' }, 30).animate({ backgroundColor: 'rgb(255,238,221)' }, 500);

    //flash success box
    $('#msg.success').animate({ backgroundColor: 'rgb(51,204,0)' }, 30).animate({ backgroundColor: 'rgb(221,255,170)' }, 500);
    
    //flash confirm box
    $('#msg.question').animate({ backgroundColor: 'rgb(51,204,0)' }, 30).animate({ backgroundColor: 'rgb(221,255,170)' }, 500);

    $('#kaptcha').click(function(){
                //点击切换验证码
                $("#kaptcha").attr("src","/ClinicCountManager/kaptcha.jpg?"+Math.floor(Math.random()*100));
                //切换验证码后清空输入框内容、后面提示字清空；
                document.getElementById("captcha").value="";
                //document.getElementById("verifyCodeSpan").innerHTML = "";
        //alert(11);
        //$(this).hide().attr('src', '/ClinicCountManager/captcha-image.do?' + Math.floor(Math.random()*100) ).fadeIn();
    });
    /* 
     * Using the JavaScript Debug library, you may issue log messages such as: 
     * debug.log("Welcome to Central Authentication Service");
     */
});
