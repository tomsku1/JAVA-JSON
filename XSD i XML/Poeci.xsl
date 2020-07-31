<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>

	<xsl:template match="CollectionOfPoems">
		<html>
			<head>
				<title></title>
			</head>


			<body>
				<h1>Zbiór wierszy</h1>
					<br></br>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="Poem">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="Author">
		<p style="font-weight: bold;"><xsl:value-of select="FirstName"/> <xsl:value-of select="LastName"/></p>
	</xsl:template>
	
	   <xsl:template match="Title">
        <h2><xsl:value-of select="."/> </h2>

    </xsl:template>
	
	<xsl:template match="Subtitle">
        <p style="font-weight: bold; margin:0; padding:0;"><xsl:value-of select="."/> </p>
        <div style="height:3%; clear:both;"></div>
    </xsl:template>
	
	<xsl:template match="Strophe">
		<br>
			<div style="background-color">
				<xsl:apply-templates/>
			</div>
		</br>
     </xsl:template>
	 
	 <xsl:template match="Verse">
        <p style="margin:0;padding:0;"><xsl:value-of select="Verse"/></p>
		<xsl:apply-templates/>
		
     </xsl:template>
	 
	 <xsl:template match="Bold">
        <b><xsl:value-of select="."/></b>
    </xsl:template>
	
	
</xsl:stylesheet>