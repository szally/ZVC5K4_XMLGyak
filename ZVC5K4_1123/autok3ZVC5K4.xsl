<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2></h2>
                <table border="1">
                    <tr bgcolor="green">
                        <th>Autók</th>
                    </tr>
                    <tr>
                        <xsl:for-each select="autok/auto">
                            <tr>
                                <td></td>
                            </tr>
                        </xsl:for-each>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>