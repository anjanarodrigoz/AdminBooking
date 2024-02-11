package com.example.adminbooking.JavaMail;


import com.example.adminbooking.Models.BookingDetails;

public class MailTemplate {


    private static MailTemplate mInstance;

    public MailTemplate(){
    }

    public static MailTemplate getInstance() {
        if (mInstance == null) {
            mInstance = new MailTemplate();
        }
        return mInstance;
    }

    public String getTemplate(BookingDetails bookingDetails){


        String mTemplate = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                "<head>\n" +
                "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "<meta content=\"width=device-width\" name=\"viewport\"/>\n" +
                "<!--[if !mso]><!-->\n" +
                "<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
                "<!--<![endif]-->\n" +
                "<title></title>\n" +
                "<!--[if !mso]><!-->\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<!--<![endif]-->\n" +
                "<style type=\"text/css\">\n" +
                "\t\tbody {\n" +
                "\t\t\tmargin: 0;\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\ttable,\n" +
                "\t\ttd,\n" +
                "\t\ttr {\n" +
                "\t\t\tvertical-align: top;\n" +
                "\t\t\tborder-collapse: collapse;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t* {\n" +
                "\t\t\tline-height: inherit;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\ta[x-apple-data-detectors=true] {\n" +
                "\t\t\tcolor: inherit !important;\n" +
                "\t\t\ttext-decoration: none !important;\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "<style id=\"media-query\" type=\"text/css\">\n" +
                "\t\t@media (max-width: 920px) {\n" +
                "\n" +
                "\t\t\t.block-grid,\n" +
                "\t\t\t.col {\n" +
                "\t\t\t\tmin-width: 320px !important;\n" +
                "\t\t\t\tmax-width: 100% !important;\n" +
                "\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.block-grid {\n" +
                "\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.col {\n" +
                "\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.col_cont {\n" +
                "\t\t\t\tmargin: 0 auto;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\timg.fullwidth,\n" +
                "\t\t\timg.fullwidthOnMobile {\n" +
                "\t\t\t\tmax-width: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col {\n" +
                "\t\t\t\tmin-width: 0 !important;\n" +
                "\t\t\t\tdisplay: table-cell !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack.two-up .col {\n" +
                "\t\t\t\twidth: 50% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num2 {\n" +
                "\t\t\t\twidth: 16.6% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num3 {\n" +
                "\t\t\t\twidth: 25% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num4 {\n" +
                "\t\t\t\twidth: 33% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num5 {\n" +
                "\t\t\t\twidth: 41.6% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num6 {\n" +
                "\t\t\t\twidth: 50% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num7 {\n" +
                "\t\t\t\twidth: 58.3% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num8 {\n" +
                "\t\t\t\twidth: 66.6% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num9 {\n" +
                "\t\t\t\twidth: 75% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num10 {\n" +
                "\t\t\t\twidth: 83.3% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.video-block {\n" +
                "\t\t\t\tmax-width: none !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.mobile_hide {\n" +
                "\t\t\t\tmin-height: 0px;\n" +
                "\t\t\t\tmax-height: 0px;\n" +
                "\t\t\t\tmax-width: 0px;\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t\toverflow: hidden;\n" +
                "\t\t\t\tfont-size: 0px;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.desktop_hide {\n" +
                "\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\tmax-height: none !important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #0f5375;\">\n" +
                "<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                "<table bgcolor=\"#0f5375\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #0f5375; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                "<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#0f5375\"><![endif]-->\n" +
                "<div style=\"background-color:transparent;\">\n" +
                "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 900px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
                "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:900px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"900\" style=\"background-color:transparent;width:900px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                "<div class=\"col num12\" style=\"min-width: 320px; max-width: 900px; display: table-cell; vertical-align: top; width: 900px;\">\n" +
                "<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                "<!--<![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: 'Courier New', Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; color: #ffffff; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; text-align: center; word-break: break-word; font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 50px;\"><span style=\"font-size: 58px;\">MELBOURNE MOVERS</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 4px dashed #000000; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: 'Courier New', Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; color: #ffffff; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; text-align: center; font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 30px;\">BOOKING DETAILS<br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "</div>\n" +
                "<!--<![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div style=\"background-color:transparent;\">\n" +
                "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 900px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
                "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:900px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"900\" style=\"background-color:transparent;width:900px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                "<div class=\"col num12\" style=\"min-width: 320px; max-width: 900px; display: table-cell; vertical-align: top; width: 900px;\">\n" +
                "<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                "<!--<![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: 'Courier New', Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; color: #ffffff; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Order ID : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getOrderId()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "</div>\n" +
                "<!--<![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div style=\"background-color:transparent;\">\n" +
                "<div class=\"block-grid mixed-two-up\" style=\"min-width: 320px; max-width: 900px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
                "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:900px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                "<div class=\"col num8\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 600px; width: 600px;\">\n" +
                "<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                "<!--<![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Name : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmName()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">E-mail : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmEmail()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Mobile Number : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmMobileNumber()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Truck : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmTruck()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Number Of Removalists : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmNum()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Packing Materials : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmPack()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "</div>\n" +
                "<!--<![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"300\" style=\"background-color:transparent;width:300px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 300px; width: 300px;\">\n" +
                "<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                "<!--<![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Date : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmDate()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Time : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmTime()+ bookingDetails.getmTime2()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Price : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmPrice()+" "+ bookingDetails.getSelect()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Deposit : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmDeposite()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">Extra Charges : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmExtra()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "</div>\n" +
                "<!--<![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div style=\"background-color:transparent;\">\n" +
                "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 900px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n" +
                "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:900px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"900\" style=\"background-color:transparent;width:900px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                "<div class=\"col num12\" style=\"min-width: 320px; max-width: 900px; display: table-cell; vertical-align: top; width: 900px;\">\n" +
                "<div class=\"col_cont\" style=\"width:100% !important;\">\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                "<!--<![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">From Address : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmFromAddress()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#ffffff;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #ffffff; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\"><strong><span style=\"font-size: 24px;\">To Address : <span style=\"color: #d9d4d4;\">"+ bookingDetails.getmToAddress()+"</span><br/></span></strong></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 4px dashed #000000; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Courier, monospace\"><![endif]-->\n" +
                "<div style=\"color:#fefcfc;font-family:Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                "<div style=\"line-height: 1.2; font-size: 12px; color: #fefcfc; font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; mso-line-height-alt: 14px;\">\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><strong><span style=\"font-size: 26px;\">Hello "+ bookingDetails.getmName()+"</span>,</strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 22px; mso-line-height-alt: 26px; margin: 0;\"><span style=\"font-size: 22px;\">Greetings From Melbourne Removalist</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">This is to confirm your house move on "+ bookingDetails.getmDate()+" around "+ bookingDetails.getmTime()+ bookingDetails.getmTime2()+".There will be "+ bookingDetails.getmNum()+" professional removalists and a (approximately around "+ bookingDetails.getCapacity()+" cubic meters in capacity) "+ bookingDetails.getmTruck()+" at your given address.It is "+ bookingDetails.getmPrice()+" "+ bookingDetails.getSelect()+" door to door charges</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">Our charges are just the hourly rate with 30 minutes increments.</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">We accept cash payments and credit card payments but for all the card payments there will be a 2.4% card payment,EFT and 30$ admin fee applicable.All prices mentioned above are excluding GST</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><strong><span style=\"font-size: 18px;\">Condition Of The Service</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">The deposit we charge is non refundable and the customers can alter the booking dates/times depends on the availabilities.</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\"></span>We are trying our best to serve within the given time frames ,but there can be unavoidable circumstances where customers may experience long wait.But we will be acknowledging the customer regarding this sort of issues and customers will be given chance to wait and get the service completed within the dame day or to pick any other date /time as they wish. </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>"+
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">This price is inclusive of:</span></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 10px; margin: 0;\"><span style=\"font-size: 16px;\">·    Truck & 2 Removalists</span></p>\n" +
                "<p style=\"line-height: 0.3; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.3; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">·    Loading & Unloading</span></p>\n" +
                "<p style=\"line-height: 0.3; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.3; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">·    Dismantling & Reassembling</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">The removalists will arrive at your pick-up location, secure all the items you will be moving with plastic furniture covers and heavy duty blankets, load them into the truck and travel towards your drop off.</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">If any furniture requires dismantling or reassembling the removalists can certainly do that for you for no other hidden charges</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><strong><span style=\"font-size: 18px;\">   All our prices are exclusive of GST</span></strong></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">We have a 2.5 hours minimum booking time for hourly rate jobs and after 2.5 hours we only charge prorate basis for the half hour increments.</span></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">Fast. Fit. Efficient professionally trained movers, quicker on the job so you save money every time</span></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">We have Debit & Credit Card Payment Facility. You could make payments for the service via card as well, with 2.5% surcharge on all card payments</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><strong><span style=\"font-size: 18px;\">*PLEASE NOTE - WE OFFER EXTENDED SERVICES FOR ALL OUR CLIENTS WITH INCLUDES MOVE OUT CLEANING & UTILITY SERVICES*</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><strong><span style=\"font-size: 18px;\">INSURANCE POLICY :</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">Our service comes equipped with Public Liability insuarance</span></p>\n" +
                "<p style=\"line-height: 0.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">We recommend you to arrange adequate insurance to cover the goods submitted for removal transit and /or your premises against any Accidental Physical Loss or Damage or Deliberate Act of a third party.</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><strong><span style=\"font-size: 18px;\">SERVICE CANCELLATION :</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">We provide the flexibility to change the service date & time as per your preference (Provided we have the availability).However, if you choose to cancel this agreement, we reserve the right to charge you a reasonable cancellation fee to recover administrative cost & loss of business. Cancellation fee is based on how much notice is given as set out below:</span></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">·     More than 14 Working Days before the Removal Due to Start - $100.00</span></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 16px;\">·     Less than 14 Working Days before the Removal was Due to Start - $200.00</span></p>\n" +
                "<p style=\"line-height: 0.5; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><strong><span style=\"font-size: 18px;\">**Please Note - Working Days refer to the normal working week of Monday to Friday and excludes Weekends & Public Holidays.</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">We look forward to complete your move with you soon!</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>"+
                "<p style=\"line-height: 1.2; word-break: break-word; font-size: 18px; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">Attached is a copy of our privacy policy, if you have any quires regarding the booking please feel free to contact us on 0481330928 anytime.</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><br/><span style=\"font-size: 18px;\">Thank you for booking with us, your satisfaction is our pleasure.</span></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><strong><span style=\"font-size: 20px;\">Thank you</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><strong><span style=\"font-size: 20px;\">Regards</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><strong><span style=\"font-size: 20px;\">Shane</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><strong><span style=\"font-size: 20px;\">MELBOURNE MOVER</span></strong></p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "<p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"> </p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if mso]></td></tr></table><![endif]-->\n" +
                "<!--[if (!mso)&(!IE)]><!-->\n" +
                "</div>\n" +
                "<!--<![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<!--[if (IE)]></div><![endif]-->\n" +
                "</body>\n" +
                "</html>";


        return mTemplate;
    }


}

