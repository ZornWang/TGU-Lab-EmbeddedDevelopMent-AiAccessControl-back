(self.webpackChunkant_design_pro=self.webpackChunkant_design_pro||[]).push([[327],{54823:function(S,m,n){"use strict";n.d(m,{Z:function(){return H}});var I=n(57338),D=n(25084),c=n(3182),l=n(57337),T=n(94043),i=n.n(T),M=n(6604),N=n(16894),P=n(8870),j=n(76649),K={REGISTER:"\u4E0A\u7535\u6CE8\u518C",DETECT_FACE:"\u8BC6\u522B\u4EBA\u8138",OPEN:"\u5F00\u95E8",WARNING:"\u8BBE\u5907\u62A5\u8B66",ERROR:"\u8BBE\u5907\u62A5\u9519"};function $(t,s){return F.apply(this,arguments)}function F(){return F=(0,c.Z)(i().mark(function t(s,f){return i().wrap(function(o){for(;;)switch(o.prev=o.next){case 0:return o.abrupt("return",(0,j.WY)("/device-log",(0,P.Z)({method:"GET",params:(0,P.Z)({},s)},f||{})));case 1:case"end":return o.stop()}},t)})),F.apply(this,arguments)}var x=n(67294),R;(function(t){t.REGISTER="REGISTER",t.DETECT_FACE="DETECT_FACE",t.OPEN="OPEN",t.WARNING="WARNING",t.ERROR="ERROR"})(R||(R={}));var L;(function(t){t.FACE="face",t.PASSWORD="password"})(L||(L={}));var A=n(71092),V=n(12968),U=n(62462),e=n(85893),z=function(s){var f=s.log,E=f.payload,o=[{title:"Face Token",dataIndex:"faceToken"},{title:"\u56FE\u7247",dataIndex:"imageID",render:function(p,a){return(0,e.jsx)(U.Z,{width:200,src:"/api/device-log/image/".concat(a.imageID)})}}];return(0,e.jsx)(e.Fragment,{children:(0,e.jsx)(A.Z,{column:1,title:"\u4EBA\u8138\u4FE1\u606F\u8BE6\u60C5",request:(0,c.Z)(i().mark(function g(){return i().wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return a.abrupt("return",{data:E||{}});case 1:case"end":return a.stop()}},g)})),columns:o})})},Y=z,C;(function(t){t.FACE="face",t.PASSWORD="password"})(C||(C={}));var b=function(s){var f=s.log,E=f.payload,o=[{title:"\u5F00\u95E8\u65B9\u5F0F",dataIndex:"method",render:function(p,a){return a.method===C.FACE?(0,e.jsx)("span",{children:"\u4EBA\u8138\u5F00\u95E8"}):a.method===C.PASSWORD?(0,e.jsx)("span",{children:"\u5BC6\u7801\u5F00\u95E8"}):(0,e.jsx)("span",{children:"-"})}}];return(0,e.jsx)(e.Fragment,{children:(0,e.jsx)(A.Z,{column:1,title:"\u4EBA\u8138\u4FE1\u606F\u8BE6\u60C5",request:(0,c.Z)(i().mark(function g(){return i().wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return a.abrupt("return",{data:E||{}});case 1:case"end":return a.stop()}},g)})),columns:o})})},k=b,Z=function(s){var f=s.showDevice,E=s.showGuest,o=s.deviceID,g=s.guestID,p=s.mini,a=(0,x.useRef)(),J=(0,x.useState)(),w=(0,l.Z)(J,2),r=w[0],y=w[1],Q=(0,x.useState)(!1),B=(0,l.Z)(Q,2),X=B[0],G=B[1],W=[{title:"LOG ID",dataIndex:"id"},{title:"\u4E8B\u4EF6",dataIndex:"event",valueEnum:K},f&&{title:"\u8BBE\u5907",dataIndex:["device","name"],search:!1,render:function(v,u){return u.device?(0,e.jsx)("a",{onClick:function(){j.m8.push("/device/".concat(u.deviceId))},children:v}):(0,e.jsx)(e.Fragment,{children:"-"})}},{title:"\u8BBE\u5907 ID",dataIndex:"deviceId",initialValue:o,hideInTable:!0},E&&{title:"\u4EBA\u5458",dataIndex:["guest","name"],search:!1,render:function(v,u){return u.guest?(0,e.jsx)("a",{onClick:function(){j.m8.push("/guest/".concat(u.guestId))},children:v}):(0,e.jsx)(e.Fragment,{children:"-"})}},{title:"\u4EBA\u5458 ID",dataIndex:"guestId",initialValue:g,hideInTable:!0},{title:"\u64CD\u4F5C\u65F6\u95F4",valueType:"dateTime",dataIndex:"createdAt",search:!1},{title:"\u64CD\u4F5C",dataIndex:"option",valueType:"option",hideInDescriptions:!0,render:function(v,u){return[(0,e.jsx)("a",{onClick:function(){G(!0),y(u)},children:"\u8BE6\u60C5"},"config")]}}].filter(Boolean);return(0,e.jsxs)(e.Fragment,{children:[(0,e.jsx)(N.ZP,{headerTitle:"\u65E5\u5FD7\u5217\u8868",actionRef:a,rowKey:"id",search:{labelWidth:120,filterType:p?"light":"query"},request:function(){var h=(0,c.Z)(i().mark(function v(u){return i().wrap(function(d){for(;;)switch(d.prev=d.next){case 0:return d.t0=M.S,d.next=3,$(u);case 3:return d.t1=d.sent,d.abrupt("return",(0,d.t0)(d.t1));case 5:case"end":return d.stop()}},v)}));return function(v){return h.apply(this,arguments)}}(),columns:W}),(0,e.jsx)(D.Z,{width:600,visible:X,onClose:function(){y(void 0),G(!1)},closable:!1,children:(r==null?void 0:r.id)&&(0,e.jsxs)(e.Fragment,{children:[(0,e.jsx)(A.Z,{column:2,title:"\u65E5\u5FD7\u8BE6\u60C5",request:(0,c.Z)(i().mark(function h(){return i().wrap(function(u){for(;;)switch(u.prev=u.next){case 0:return u.abrupt("return",{data:r||{}});case 1:case"end":return u.stop()}},h)})),params:{id:r==null?void 0:r.id},columns:W}),(r==null?void 0:r.event)===R.DETECT_FACE&&(0,e.jsx)(Y,{log:r}),(r==null?void 0:r.event)===R.OPEN&&(0,e.jsx)(k,{log:r})]})})]})};Z.defaultProps={showDevice:!0,showGuest:!0};var H=Z},18290:function(S,m,n){"use strict";n.r(m);var I=n(54823),D=n(70844),c=n(67294),l=n(85893),T=function(){return(0,l.jsx)(D.ZP,{children:(0,l.jsx)(I.Z,{})})};m.default=T},6604:function(S,m,n){"use strict";n.d(m,{S:function(){return I}});var I=function(c){var l=c.data;return{data:l.result,total:l.total,success:!0,pageSize:l.pageSize,current:l.current}}}}]);
