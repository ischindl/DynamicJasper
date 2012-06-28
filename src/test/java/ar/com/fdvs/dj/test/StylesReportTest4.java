/*
 * Copyright (c) 2012, FDV Solutions S.A.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the FDV Solutions S.A. nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL FDV Solutions S.A. BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ar.com.fdvs.dj.test;

import java.awt.Color;

import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.GroupBuilder;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.GroupLayout;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.entities.DJGroup;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn;

/**
 * This test aims to generate a report with almost no styles, ensuring that there are no errors
 * as result of the lack of style or fonts.
 * 
 * See bug 2817859 at SF
 * 
 * @author mamana
 *
 */
public class StylesReportTest4 extends BaseDjReportTest {

	public DynamicReport buildReport() throws Exception {
		
		DynamicReportBuilder drb = new DynamicReportBuilder();
		Integer margin = new Integer(20);
		drb.setTitle("November 2006 sales report")					//defines the title of the report
			.setSubtitle("The items in this report correspond "
					+"to the main products: DVDs, Books, Foods and Magazines")
			.setTitleHeight(new Integer(30))
			.setSubtitleHeight(new Integer(20))
			.setDetailHeight(new Integer(15))
			.setLeftMargin(margin)
			.setRightMargin(margin)
			.setTopMargin(margin)
			.setBottomMargin(margin)
			.setColumnsPerPage(new Integer(1))
			.setColumnSpace(new Integer(5));

		Style style1 = new Style("style1");
		style1.setFont(Font.ARIAL_MEDIUM_BOLD);
		style1.setHorizontalAlign(HorizontalAlign.CENTER);
		drb.addStyle(style1);

		Style style2 = Style.createBlankStyle("style2", "style1");
		style2.setTextColor(Color.BLUE);
		drb.addStyle(style2);
		
		AbstractColumn columnState = ColumnBuilder.getNew().setColumnProperty("state", String.class.getName())
			.setTitle("State").setWidth(new Integer(85))
			.setStyle(style1).build();

		AbstractColumn columnBranch = ColumnBuilder.getNew().setColumnProperty("branch", String.class.getName())
			.setTitle("Branch").setWidth(new Integer(85))
			.setStyle(style2).build();

		drb.addColumn(columnBranch);
		drb.addColumn(columnState);		

		DJGroup g1 = new GroupBuilder()
		.setCriteriaColumn((PropertyColumn) columnBranch)

		.setGroupLayout(GroupLayout.VALUE_IN_HEADER_WITH_HEADERS_AND_COLUMN_NAME)
		.build();
		drb.addGroup(g1);
		
		drb.setUseFullPageWidth(true);

		DynamicReport dr = drb.build();
		return dr;
	}

	public static void main(String[] args) throws Exception {
		StylesReportTest4 test = new StylesReportTest4();
		test.testReport();
		JasperViewer.viewReport(test.jp);
	}

}
