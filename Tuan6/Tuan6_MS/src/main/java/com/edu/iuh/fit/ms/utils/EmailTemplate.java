package com.edu.iuh.fit.ms.utils;

import com.edu.iuh.fit.ms.entity.Order;
import com.edu.iuh.fit.ms.entity.OrderStatus;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EmailTemplate {
    public static String createEmailBody(Order order){

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String rs = order.getStatus() == OrderStatus.ACCEPTED ?
                "        <tr>\n" +
                        "            <td><strong>Tổng tiền:</strong></td>\n" +
                        "            <td>"+currencyFormat.format(order.getTotal())+"</td>\n" +
                        "        </tr>\n" :

                "        <tr>\n" +
                        "            <td><strong>Thông tin chi tiết</strong></td>\n" +
                        "            <td>"+ "Số lượng trong kho không đủ"+"</td>\n" +
                        "        </tr>\n" ;


        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            width: 800px;\n" +
                "            margin: 0 auto;\n" +
                "            font-family: Arial, sans-serif;\n" +
                "        }\n" +
                "\n" +
                "        #table1 {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "        }\n" +
                "\n" +
                "        #table1 th,\n" +
                "        #table1 td {\n" +
                "            padding: 8px;\n" +
                "            text-align: left;\n" +
                "            border: 1px solid #ddd;\n" +
                "        }\n" +
                "\n" +
                "        #table1 th {\n" +
                "            background-color: #f2f2f2;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "        <tr>\n" +
                "         <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;font-size:0px\"><img src=\"https://fbpatbx.stripocdn.email/content/guids/CABINET_f3fc38cf551f5b08f70308b6252772b8/images/96671618383886503.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"100\"></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "         <td align=\"center\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-top:15px;padding-bottom:15px\"><h1 style=\"Margin:0;line-height:55px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:46px;font-style:normal;font-weight:bold;color:#333333\">Thông tin đơn hàng</h1></td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "\n" +
                "    <table id=\"table1\">\n" +
                "        \n" +
                "        <tr>\n" +
                "            <th colspan=\"2\">Thông tin đơn hàng</th>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td><strong>Khách hàng:</strong></td>\n" +
                "            <td>"+order.getCustomerName()+"</td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td><strong>Ngày đặt:</strong></td>\n" +
                "            <td>"+order.getCreatedAt()+"</td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td><strong>Sản phẩm:</strong></td>\n" +
                "            <td>"+order.getProduct().getName()+"</td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td><strong>Số luọng:</strong></td>\n" +
                "            <td>"+order.getQuantity()+"</td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td><strong>Trạng thái:</strong></td>\n" +
                "            <td>"+order.getStatus().toString()+"</td>\n" +
                "        </tr>\n" +
                "\n" + rs +
                "\n" +
                "    </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }

}