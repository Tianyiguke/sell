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
                    <form id="productFrom" method="post" action="${basePath}/seller/product/add">
                        <fieldset>
                            <legend>增加商品</legend>
                            <label>商品名称</label><br>
                            <input id="productName" name="productName" type="text" /> <span class="help-block"></span><br><br>
                            <label>单价  </label><br>
                            <input id="productPrice" name="productPrice" type="text" /> <span class="help-block"></span><br><br>
                            <label>库存  </label><br>
                            <input id="productStock" name="productStock" type="text" /> <span class="help-block"></span><br><br>
                            <label>描述  </label><br>
                            <input id="productDescription" name="productDescription" type="text" /> <span class="help-block"></span><br><br>
                            <label>图片  </label><br>
                            <input id="productIcon" name="productIcon" type="text" /> <span class="help-block"></span><br><br>
                            <label>商品状态</label><br>
                            <input  name="productStatus" value="0" type="radio" checked/> 上架<span class="help-block"></span>
                            <input  name="productStatus" value="1" type="radio" /> 下架<span class="help-block"></span><br><br>

                            <label>类目编号</label><br>
                            <select id="categoryType" name="categoryType"  > <span class="help-block"></span><br><br>
                                  <#list productCategoryList as productCategory>
                                  <option value="${productCategory.categoryType}">${productCategory.categoryName}</option>
                                  </#list>
                            </select>
                            <br>
                            <br>
                            <input type="submit" value="提交">
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