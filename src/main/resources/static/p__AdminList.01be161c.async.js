(self.webpackChunkant_design_pro=self.webpackChunkant_design_pro||[]).push([[832],{5966:function(K,T,e){"use strict";var C=e(22122),j=e(81253),S=e(67294),E=e(21257),x=["fieldProps","proFieldProps"],A=["fieldProps","proFieldProps"],w="text",Z=function(y){var a=y.fieldProps,R=y.proFieldProps,F=(0,j.Z)(y,x);return S.createElement(E.Z,(0,C.Z)({mode:"edit",valueType:w,fieldProps:a,filedConfig:{valueType:w},proFieldProps:R},F))},Y=function(y){var a=y.fieldProps,R=y.proFieldProps,F=(0,j.Z)(y,A);return S.createElement(E.Z,(0,C.Z)({mode:"edit",valueType:"password",fieldProps:a,proFieldProps:R,filedConfig:{valueType:w}},F))},v=Z;v.Password=Y,v.displayName="ProFormComponent",T.Z=v},68938:function(K,T,e){"use strict";e.r(T),e.d(T,{default:function(){return oe}});var C=e(57338),j=e(25084),S=e(57663),E=e(71577),x=e(62350),A=e(75443),w=e(57337),Z=e(8870),Y=e(34792),v=e(48086),c=e(3182),y=e(94043),a=e.n(y),R=e(49101),F=e(67294),k=e(70844),q=e(16894),z=e(37476),_=e(71092),$=e(76649);function ee(i,n){return M.apply(this,arguments)}function M(){return M=(0,c.Z)(a().mark(function i(n,t){return a().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return r.abrupt("return",(0,$.WY)("/user",(0,Z.Z)({method:"GET",params:(0,Z.Z)({},n)},t||{})));case 1:case"end":return r.stop()}},i)})),M.apply(this,arguments)}function re(i,n){return W.apply(this,arguments)}function W(){return W=(0,c.Z)(a().mark(function i(n,t){return a().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return r.abrupt("return",(0,$.WY)("/user",(0,Z.Z)({data:n,method:"PUT"},t||{})));case 1:case"end":return r.stop()}},i)})),W.apply(this,arguments)}function ae(i,n){return O.apply(this,arguments)}function O(){return O=(0,c.Z)(a().mark(function i(n,t){return a().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return r.abrupt("return",(0,$.WY)("/user",(0,Z.Z)({data:n,method:"POST"},t||{})));case 1:case"end":return r.stop()}},i)})),O.apply(this,arguments)}function ne(i,n){return I.apply(this,arguments)}function I(){return I=(0,c.Z)(a().mark(function i(n,t){return a().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return r.abrupt("return",(0,$.WY)("/user",(0,Z.Z)({data:n,method:"DELETE"},t||{})));case 1:case"end":return r.stop()}},i)})),I.apply(this,arguments)}var ue=e(6604),L=e(5966),l=e(85893),te=function(n){var t=n.isEdit;return(0,l.jsxs)(l.Fragment,{children:[(0,l.jsx)(L.Z,{label:"\u90AE\u7BB1",name:"email",rules:[{required:!0,message:"\u8FD9\u662F\u5FC5\u586B\u9879"}]}),(0,l.jsx)(L.Z,{label:"\u7528\u6237\u540D",name:"name",rules:[{required:!0,message:"\u8FD9\u662F\u5FC5\u586B\u9879"}]}),(0,l.jsx)(L.Z.Password,{label:"\u5BC6\u7801",name:"password",placeholder:t?"\u4E0D\u4FEE\u6539\u8BF7\u7559\u7A7A":void 0,rules:t?[]:[{required:!0,message:"\u8FD9\u662F\u5FC5\u586B\u9879"}]})]})},G=te,se=function(){var i=(0,c.Z)(a().mark(function n(t){var d;return a().wrap(function(u){for(;;)switch(u.prev=u.next){case 0:return d=v.default.loading("\u6B63\u5728\u6DFB\u52A0"),u.prev=1,u.next=4,ae((0,Z.Z)({},t));case 4:return d(),v.default.success("\u6DFB\u52A0\u6210\u529F"),u.abrupt("return",!0);case 9:return u.prev=9,u.t0=u.catch(1),d(),v.default.error("\u6DFB\u52A0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5\uFF01"),u.abrupt("return",!1);case 14:case"end":return u.stop()}},n,null,[[1,9]])}));return function(t){return i.apply(this,arguments)}}(),le=function(){var i=(0,c.Z)(a().mark(function n(t,d){var r;return a().wrap(function(m){for(;;)switch(m.prev=m.next){case 0:return r=v.default.loading("\u6B63\u5728\u914D\u7F6E"),m.prev=1,m.next=4,re((0,Z.Z)((0,Z.Z)({},d),t));case 4:return r(),v.default.success("\u4FEE\u6539\u6210\u529F"),m.abrupt("return",!0);case 9:return m.prev=9,m.t0=m.catch(1),r(),v.default.error("\u4FEE\u6539\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5\uFF01"),m.abrupt("return",!1);case 14:case"end":return m.stop()}},n,null,[[1,9]])}));return function(t,d){return i.apply(this,arguments)}}(),ie=function(){var i=(0,c.Z)(a().mark(function n(t){var d;return a().wrap(function(u){for(;;)switch(u.prev=u.next){case 0:return d=v.default.loading("\u6B63\u5728\u5220\u9664"),u.prev=1,u.next=4,ne({id:t.id});case 4:return d(),v.default.success("\u5220\u9664\u6210\u529F\uFF0C\u5373\u5C06\u5237\u65B0"),u.abrupt("return",!0);case 9:return u.prev=9,u.t0=u.catch(1),d(),v.default.error("\u5220\u9664\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5"),u.abrupt("return",!1);case 14:case"end":return u.stop()}},n,null,[[1,9]])}));return function(t){return i.apply(this,arguments)}}(),de=function(){var n=(0,F.useState)(!1),t=(0,w.Z)(n,2),d=t[0],r=t[1],u=(0,F.useState)(!1),m=(0,w.Z)(u,2),N=m[0],U=m[1],ce=(0,F.useState)(!1),H=(0,w.Z)(ce,2),pe=H[0],J=H[1],B=(0,F.useRef)(),fe=(0,F.useState)(),Q=(0,w.Z)(fe,2),p=Q[0],V=Q[1],X=[{title:"ID",dataIndex:"id",render:function(h,o){return(0,l.jsx)("a",{onClick:function(){V(o),J(!0)},children:h})}},{title:"\u59D3\u540D",dataIndex:"name"},{title:"\u90AE\u7BB1",dataIndex:"email"},{title:"\u64CD\u4F5C",dataIndex:"option",valueType:"option",render:function(h,o){return[(0,l.jsx)("a",{onClick:function(){U(!0),V(o)},children:"\u7F16\u8F91"},"config"),(0,l.jsx)(A.Z,{title:"\u662F\u5426\u786E\u8BA4\u5220\u9664\u8BE5\u7528\u6237\uFF1F",onConfirm:(0,c.Z)(a().mark(function P(){var s,b;return a().wrap(function(D){for(;;)switch(D.prev=D.next){case 0:return D.next=2,ie(o);case 2:s=D.sent,s&&((b=B.current)===null||b===void 0||b.reload());case 4:case"end":return D.stop()}},P)})),okText:"\u786E\u8BA4",cancelText:"\u53D6\u6D88",children:(0,l.jsx)("a",{children:"\u5220\u9664"},"delete")},"delete")]}}];return(0,l.jsxs)(k.ZP,{children:[(0,l.jsx)(q.ZP,{headerTitle:"\u7528\u6237\u5217\u8868",actionRef:B,rowKey:"id",search:{labelWidth:120},toolBarRender:function(){return[(0,l.jsxs)(E.Z,{type:"primary",onClick:function(){r(!0)},children:[(0,l.jsx)(R.Z,{})," \u65B0\u5EFA"]},"primary")]},request:function(){var g=(0,c.Z)(a().mark(function h(o){return a().wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return s.t0=ue.S,s.next=3,ee(o);case 3:return s.t1=s.sent,s.abrupt("return",(0,s.t0)(s.t1));case 5:case"end":return s.stop()}},h)}));return function(h){return g.apply(this,arguments)}}(),columns:X}),d&&(0,l.jsx)(z.Z,{title:"\u65B0\u5EFA\u5E73\u53F0\u7528\u6237",visible:d,onVisibleChange:r,width:"736px",onFinish:function(){var g=(0,c.Z)(a().mark(function h(o){var P,s;return a().wrap(function(f){for(;;)switch(f.prev=f.next){case 0:return f.next=2,se(o);case 2:return P=f.sent,P&&(r(!1),(s=B.current)===null||s===void 0||s.reload()),f.abrupt("return",P);case 5:case"end":return f.stop()}},h)}));return function(h){return g.apply(this,arguments)}}(),children:(0,l.jsx)(G,{})}),N&&(0,l.jsx)(z.Z,{title:"\u4FEE\u6539\u5E73\u53F0\u7528\u6237",width:"736px",visible:N,onVisibleChange:U,initialValues:p,onFinish:function(){var g=(0,c.Z)(a().mark(function h(o){var P,s;return a().wrap(function(f){for(;;)switch(f.prev=f.next){case 0:return f.next=2,le((0,Z.Z)((0,Z.Z)({},o),{},{id:p==null?void 0:p.id}));case 2:return P=f.sent,P&&(U(!1),(s=B.current)===null||s===void 0||s.reload()),f.abrupt("return",P);case 5:case"end":return f.stop()}},h)}));return function(h){return g.apply(this,arguments)}}(),children:(0,l.jsx)(G,{isEdit:!0})}),(0,l.jsx)(j.Z,{width:600,visible:pe,onClose:function(){V(void 0),J(!1)},closable:!1,children:(p==null?void 0:p.name)&&(0,l.jsx)(_.Z,{column:2,title:p==null?void 0:p.name,request:(0,c.Z)(a().mark(function g(){return a().wrap(function(o){for(;;)switch(o.prev=o.next){case 0:return o.abrupt("return",{data:p||{}});case 1:case"end":return o.stop()}},g)})),params:{id:p==null?void 0:p.name},columns:X})})]})},oe=de},6604:function(K,T,e){"use strict";e.d(T,{S:function(){return C}});var C=function(S){var E=S.data;return{data:E.result,total:E.total,success:!0,pageSize:E.pageSize,current:E.current}}}}]);