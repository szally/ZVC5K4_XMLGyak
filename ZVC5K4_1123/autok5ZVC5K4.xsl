<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Határozza meg az autótípusokat és példányaik darabszámát példányszám szerint csökkenő sorrendben! </h2>
                <table border="1">
                    <tr bgcolor="green">
                        <th>Autók Típus</th>
                        <th>Darabszám</th>
                    </tr>
                    <tr>
                        <xsl:for-each select="autok/auto">

                            <tr>
                                <td><xsl:value-of select="tipus"/></td>
                                <td><xsl:value-of select="count(tipus)"/></td>
                            </tr>
                        </xsl:for-each>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>