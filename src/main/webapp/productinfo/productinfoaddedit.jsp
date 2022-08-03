<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="infoaddedit" id="infoaddeditBG">
	<form action="productinfoaddedit.do" method="post" class="infoaddedit" id="infoaddeditform">
			<div class="productinfobox" id="productinfobox">
			<p class="productinfo" id="productnumber">#</p>
			<h1 class="productinfo" id="producttitle"><input type="text" class="infoaddeditinput" id="infotitleaddedit"/></h1>
			<div class="productinfo" id="productimageslist">
				<input type="image" class="infoaddeditinput" id="infoaddeditinput"/>
				<div class="productimage" id="productimagethumbnail">image</div>
			</div>
			<table class="productinfo" id="productinfotable">
				<tr class="productinfotableTR" id="productcountryregion">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productcountryregion">region</label></td>
					<td class="productinfotableTD"><input type="text" class="infoaddeditinput" id="productcountryregionaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="productkind">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productkind">kind</label></td>
					<td class="productinfotableTD"><input type="text" class="infoaddeditinput" id="productkindregionaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="productsugarcontent">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productsugarcontent">sugarcontent</label></td>
					<td class="productinfotableTD"><input type="number" class="infoaddeditinput" id="productsugarcontentaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="productacidity">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productacidity">acidity</label></td>
					<td class="productinfotableTD"><input type="number" class="infoaddeditinput" id="productacidityaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="productbody">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productbody">body</label></td>
					<td class="productinfotableTD"><input type="number" class="infoaddeditinput" id="productbodyaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="producttannin">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="producttannin">tannin</label></td>
					<td class="productinfotableTD"><input type="number" class="infoaddeditinput" id="producttanninaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="productprice">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productprice">price</label></td>
					<td class="productinfotableTD"><input type="number" class="infoaddeditinput" id="productpriceaddedit"/></td>
				</tr>
				<tr class="productinfotableTR" id="productfood">
					<td class="productinfotableTD"><label class="productinfotablelabel" for="productfood">recommendable foods</label></td>
					<td class="productinfotableTD"><input type="text" class="infoaddeditinput" id="productfoodsregionaddedit"/></td>
				</tr>
			</table>
			<textarea class="infoaddeditinput" id="productdescriptionaddedit"></textarea>
		</div>
	</form>
</div>
</body>
</html>