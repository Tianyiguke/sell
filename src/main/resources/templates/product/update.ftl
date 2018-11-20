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
                    <form id="productFrom" method="post" action="${basePath}/seller/product/updateProduct">

                        <fieldset>
                            <legend>增加商品</legend>
                            <label>商品ID</label><br>
                            <input id="productId" name="productId" type="text" value="${productInfo.productId}"/> <span class="help-block"></span><br>
                            <label>商品名称</label><br>
                            <input id="productName" name="productName" type="text" value="${productInfo.productName}"/> <span class="help-block"></span><br>
                            <label>单价  </label><br>
                            <input id="productPrice" name="productPrice" type="text" value="${productInfo.productPrice}"/> <span class="help-block"></span><br>
                            <label>库存  </label><br>
                            <input id="productStock" name="productStock" type="text" value="${productInfo.productStock}"/> <span class="help-block"></span><br>
                            <label>描述  </label><br>
                            <input id="productDescription" name="productDescription" type="text" value="${productInfo.productDescription}"/> <span class="help-block"></span><br>
                            <label>图片  </label><br>
                            <input id="productIcon" name="productIcon" type="text" value="${productInfo.productIcon}"/> <span class="help-block"></span><br>
                            <label>商品状态</label><br>
                            <input  name="productStatus" type="radio" <#if productInfo.productStatus == 0> checked</#if> value="0"   /> 上架<span class="help-block"></span>
                            <input  name="productStatus" type="radio" <#if productInfo.productStatus == 1> checked</#if> value="1"   /> 下架<span class="help-block"></span><br>
                            <label>类目编号</label><br>
                            <input id="categoryType" name="categoryType" type="text" value="${productInfo.categoryType}"/> <span class="help-block"></span>
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