package packageB;

import packageA.ClassA;


public class ClassB{

	public static void main(String[] x) {
		ClassA a = new ClassA();
		var b = "baaaa";
		String c = """
			this is the value: b
			""";
		String d = "function(request, response, ctx, collection, solrServer, solrServerFactory) {\n  // Skip solr unless everything works as expected\n  ctx.set(\"skip_solr\", \"true\");\n  try {\n    //throw(\"test error in try...\");\n    var started = Java.type(\"java.lang.System\").currentTimeMillis();\n    ctx.set(\"started\", started);\n\n    var securityTrimmingEnabled = true;\n\n    if (request == null) {return}\n    var upn = request.getFirstParam(\"upnid\");\n \n    if (upn == null) {return}\n\n    // split username and domain out of UPN\n    var username = null;\n    var domain = null;\n    if (upn.toLowerCase().endsWith(\"@xtonet.com\")) {\n      username = upn.substr(0, upn.indexOf('@'));\n      domain = \"XTO\";\n    } else {\n      var regex = java.util.regex.Pattern.compile(\"(.*)@(.*)\\.(?:XOM|xom)\\.(?:COM|com)$\").matcher(upn);\n      if (regex.find()) {\n        username = regex.group(1);\n        domain = regex.group(2);\n      }\n    }\n    if (username == null || domain == null) {return}\n\n    var buf = new java.lang.StringBuilder();\n    buf.append(domain.trim().toLowerCase());\n    buf.append(\"\\\\\");\n    buf.append(username.trim().toLowerCase());\n    request.removeParam(\"username\");\n    request.addParam(\"username\", buf.toString());\n    var escapedUsername = org.apache.solr.client.solrj.util.ClientUtils.escapeQueryChars(buf.toString());\n\n    var sec_fq = \"{!join from=_lw_acl_ss to=_lw_acl_ss method=topLevelDV}{!graph from=inbound_ss to=outbound_ss returnOnlyLeaf=true}_lw_acl_ss:\\\"\" + escapedUsername + \"\\\"\";\n    logger.info(\"Sec fq: {}\", sec_fq);\n    if (securityTrimmingEnabled) {\n      request.addParam(\"fq\", sec_fq);\n    }\n    // Only set this if everything is successful:\n    ctx.set(\"skip_solr\", \"false\");\n  } catch(err) {\n    //throw(\"test error in catch...\");\n    logger.error(\"Error in JS Security Trimming:  \" + err.toString());\n    ctx.set(\"skip_solr\", \"true\");\n  }\n}";
		System.out.println("string: " + d);
		System.out.println("done");
	}

}
