<!DOCTYPE html>
<html lang="zh">
<#include "../common/header.ftl">
<body>

<div id="main-wrapper">
    <#include "../common/sidebar.ftl">

    <#include "../common/topbar.ftl">

    <!-- 页面主体内容 -->
    <!-- Page wrapper  -->
    <div class="page-wrapper">

        <!-- 页面功能导航 -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-5 align-self-center">
                    <h4 class="page-title">商品管理</h4>
                    <div class="d-flex align-items-center"></div>
                </div>
            </div>
        </div>

        <!-- 页面主体信息 -->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <form id="categoryFrom" method="post" action="${basePath}/seller/category/update">
                        <fieldset>
                            <legend>修改类目</legend>
                            <label>类目id</label><br>
                            <input id="categoryId" name="categoryId" type="text"  value="${productCategory.categoryId}"  /> <span class="help-block"></span><br><br>
                            <label>类目名称</label><br>
                            <input id="categoryName" name="categoryName" type="text"  value="${productCategory.categoryName}"  /> <span class="help-block"></span><br><br>
                            <label>类目编号</label><br>
                            <input id="categoryType" name="categoryType" type="text"  readonly  value="${productCategory.categoryType}" /> <span class="help-block"></span>
                            <br>
                            <br>
                            <input type="submit" value="修改类目">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>


<#include "../common/layout.ftl">

<#include "../common/js.ftl">


</body>
</html>