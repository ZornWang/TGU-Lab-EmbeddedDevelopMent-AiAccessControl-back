(self.webpackChunkant_design_pro=self.webpackChunkant_design_pro||[]).push([[155],{11965:function(ee,S,s){"use strict";s.d(S,{Z:function(){return x}});var d=s(82961);function x(h,C){var i=typeof Symbol!="undefined"&&h[Symbol.iterator]||h["@@iterator"];if(!i){if(Array.isArray(h)||(i=(0,d.Z)(h))||C&&h&&typeof h.length=="number"){i&&(h=i);var a=0,f=function(){};return{s:f,n:function(){return a>=h.length?{done:!0}:{done:!1,value:h[a++]}},e:function(I){throw I},f}}throw new TypeError(`Invalid attempt to iterate non-iterable instance.
In order to be iterable, non-array objects must have a [Symbol.iterator]() method.`)}var v=!0,O=!1,g;return{s:function(){i=i.call(h)},n:function(){var I=i.next();return v=I.done,I},e:function(I){O=!0,g=I},f:function(){try{!v&&i.return!=null&&i.return()}finally{if(O)throw g}}}}},57838:function(ee,S,s){"use strict";s.d(S,{Z:function(){return h}});var d=s(28481),x=s(67294);function h(){var C=x.useReducer(function(f){return f+1},0),i=(0,d.Z)(C,2),a=i[1];return a}},84378:function(ee,S,s){"use strict";s.d(S,{Z:function(){return I}});var d=s(81626),x=s(22122),h={locale:"zh_CN",today:"\u4ECA\u5929",now:"\u6B64\u523B",backToToday:"\u8FD4\u56DE\u4ECA\u5929",ok:"\u786E\u5B9A",timeSelect:"\u9009\u62E9\u65F6\u95F4",dateSelect:"\u9009\u62E9\u65E5\u671F",weekSelect:"\u9009\u62E9\u5468",clear:"\u6E05\u9664",month:"\u6708",year:"\u5E74",previousMonth:"\u4E0A\u4E2A\u6708 (\u7FFB\u9875\u4E0A\u952E)",nextMonth:"\u4E0B\u4E2A\u6708 (\u7FFB\u9875\u4E0B\u952E)",monthSelect:"\u9009\u62E9\u6708\u4EFD",yearSelect:"\u9009\u62E9\u5E74\u4EFD",decadeSelect:"\u9009\u62E9\u5E74\u4EE3",yearFormat:"YYYY\u5E74",dayFormat:"D\u65E5",dateFormat:"YYYY\u5E74M\u6708D\u65E5",dateTimeFormat:"YYYY\u5E74M\u6708D\u65E5 HH\u65F6mm\u5206ss\u79D2",previousYear:"\u4E0A\u4E00\u5E74 (Control\u952E\u52A0\u5DE6\u65B9\u5411\u952E)",nextYear:"\u4E0B\u4E00\u5E74 (Control\u952E\u52A0\u53F3\u65B9\u5411\u952E)",previousDecade:"\u4E0A\u4E00\u5E74\u4EE3",nextDecade:"\u4E0B\u4E00\u5E74\u4EE3",previousCentury:"\u4E0A\u4E00\u4E16\u7EAA",nextCentury:"\u4E0B\u4E00\u4E16\u7EAA"},C=h,i={placeholder:"\u8BF7\u9009\u62E9\u65F6\u95F4",rangePlaceholder:["\u5F00\u59CB\u65F6\u95F4","\u7ED3\u675F\u65F6\u95F4"]},a=i,f={lang:(0,x.Z)({placeholder:"\u8BF7\u9009\u62E9\u65E5\u671F",yearPlaceholder:"\u8BF7\u9009\u62E9\u5E74\u4EFD",quarterPlaceholder:"\u8BF7\u9009\u62E9\u5B63\u5EA6",monthPlaceholder:"\u8BF7\u9009\u62E9\u6708\u4EFD",weekPlaceholder:"\u8BF7\u9009\u62E9\u5468",rangePlaceholder:["\u5F00\u59CB\u65E5\u671F","\u7ED3\u675F\u65E5\u671F"],rangeYearPlaceholder:["\u5F00\u59CB\u5E74\u4EFD","\u7ED3\u675F\u5E74\u4EFD"],rangeMonthPlaceholder:["\u5F00\u59CB\u6708\u4EFD","\u7ED3\u675F\u6708\u4EFD"],rangeWeekPlaceholder:["\u5F00\u59CB\u5468","\u7ED3\u675F\u5468"]},C),timePickerLocale:(0,x.Z)({},a)};f.lang.ok="\u786E \u5B9A";var v=f,O=v,g="${label}\u4E0D\u662F\u4E00\u4E2A\u6709\u6548\u7684${type}",P={locale:"zh-cn",Pagination:d.Z,DatePicker:v,TimePicker:a,Calendar:O,global:{placeholder:"\u8BF7\u9009\u62E9"},Table:{filterTitle:"\u7B5B\u9009",filterConfirm:"\u786E\u5B9A",filterReset:"\u91CD\u7F6E",filterEmptyText:"\u65E0\u7B5B\u9009\u9879",selectAll:"\u5168\u9009\u5F53\u9875",selectInvert:"\u53CD\u9009\u5F53\u9875",selectNone:"\u6E05\u7A7A\u6240\u6709",selectionAll:"\u5168\u9009\u6240\u6709",sortTitle:"\u6392\u5E8F",expand:"\u5C55\u5F00\u884C",collapse:"\u5173\u95ED\u884C",triggerDesc:"\u70B9\u51FB\u964D\u5E8F",triggerAsc:"\u70B9\u51FB\u5347\u5E8F",cancelSort:"\u53D6\u6D88\u6392\u5E8F"},Modal:{okText:"\u786E\u5B9A",cancelText:"\u53D6\u6D88",justOkText:"\u77E5\u9053\u4E86"},Popconfirm:{cancelText:"\u53D6\u6D88",okText:"\u786E\u5B9A"},Transfer:{searchPlaceholder:"\u8BF7\u8F93\u5165\u641C\u7D22\u5185\u5BB9",itemUnit:"\u9879",itemsUnit:"\u9879",remove:"\u5220\u9664",selectCurrent:"\u5168\u9009\u5F53\u9875",removeCurrent:"\u5220\u9664\u5F53\u9875",selectAll:"\u5168\u9009\u6240\u6709",removeAll:"\u5220\u9664\u5168\u90E8",selectInvert:"\u53CD\u9009\u5F53\u9875"},Upload:{uploading:"\u6587\u4EF6\u4E0A\u4F20\u4E2D",removeFile:"\u5220\u9664\u6587\u4EF6",uploadError:"\u4E0A\u4F20\u9519\u8BEF",previewFile:"\u9884\u89C8\u6587\u4EF6",downloadFile:"\u4E0B\u8F7D\u6587\u4EF6"},Empty:{description:"\u6682\u65E0\u6570\u636E"},Icon:{icon:"\u56FE\u6807"},Text:{edit:"\u7F16\u8F91",copy:"\u590D\u5236",copied:"\u590D\u5236\u6210\u529F",expand:"\u5C55\u5F00"},PageHeader:{back:"\u8FD4\u56DE"},Form:{optional:"\uFF08\u53EF\u9009\uFF09",defaultValidateMessages:{default:"\u5B57\u6BB5\u9A8C\u8BC1\u9519\u8BEF${label}",required:"\u8BF7\u8F93\u5165${label}",enum:"${label}\u5FC5\u987B\u662F\u5176\u4E2D\u4E00\u4E2A[${enum}]",whitespace:"${label}\u4E0D\u80FD\u4E3A\u7A7A\u5B57\u7B26",date:{format:"${label}\u65E5\u671F\u683C\u5F0F\u65E0\u6548",parse:"${label}\u4E0D\u80FD\u8F6C\u6362\u4E3A\u65E5\u671F",invalid:"${label}\u662F\u4E00\u4E2A\u65E0\u6548\u65E5\u671F"},types:{string:g,method:g,array:g,object:g,number:g,date:g,boolean:g,integer:g,float:g,regexp:g,email:g,url:g,hex:g},string:{len:"${label}\u987B\u4E3A${len}\u4E2A\u5B57\u7B26",min:"${label}\u6700\u5C11${min}\u4E2A\u5B57\u7B26",max:"${label}\u6700\u591A${max}\u4E2A\u5B57\u7B26",range:"${label}\u987B\u5728${min}-${max}\u5B57\u7B26\u4E4B\u95F4"},number:{len:"${label}\u5FC5\u987B\u7B49\u4E8E${len}",min:"${label}\u6700\u5C0F\u503C\u4E3A${min}",max:"${label}\u6700\u5927\u503C\u4E3A${max}",range:"${label}\u987B\u5728${min}-${max}\u4E4B\u95F4"},array:{len:"\u987B\u4E3A${len}\u4E2A${label}",min:"\u6700\u5C11${min}\u4E2A${label}",max:"\u6700\u591A${max}\u4E2A${label}",range:"${label}\u6570\u91CF\u987B\u5728${min}-${max}\u4E4B\u95F4"},pattern:{mismatch:"${label}\u4E0E\u6A21\u5F0F\u4E0D\u5339\u914D${pattern}"}}},Image:{preview:"\u9884\u89C8"}},I=P},81626:function(ee,S){"use strict";S.Z={items_per_page:"\u6761/\u9875",jump_to:"\u8DF3\u81F3",jump_to_confirm:"\u786E\u5B9A",page:"\u9875",prev_page:"\u4E0A\u4E00\u9875",next_page:"\u4E0B\u4E00\u9875",prev_5:"\u5411\u524D 5 \u9875",next_5:"\u5411\u540E 5 \u9875",prev_3:"\u5411\u524D 3 \u9875",next_3:"\u5411\u540E 3 \u9875",page_size:"\u9875\u7801"}},12435:function(ee,S,s){"use strict";s.d(S,{Z:function(){return g}});var d=s(85061),x=s(6610),h=s(74204),C=s(70183),i=[],a="ant-scrolling-effect",f=new RegExp("".concat(a),"g"),v=0,O=new Map,g=function P(I){var w=this;(0,x.Z)(this,P),this.lockTarget=void 0,this.options=void 0,this.getContainer=function(){var R;return(R=w.options)===null||R===void 0?void 0:R.container},this.reLock=function(R){var L=i.find(function(y){var W=y.target;return W===w.lockTarget});L&&w.unLock(),w.options=R,L&&(L.options=R,w.lock())},this.lock=function(){var R;if(!i.some(function($){var k=$.target;return k===w.lockTarget})){if(i.some(function($){var k,F=$.options;return(F==null?void 0:F.container)===((k=w.options)===null||k===void 0?void 0:k.container)})){i=[].concat((0,d.Z)(i),[{target:w.lockTarget,options:w.options}]);return}var L=0,y=((R=w.options)===null||R===void 0?void 0:R.container)||document.body;(y===document.body&&window.innerWidth-document.documentElement.clientWidth>0||y.scrollHeight>y.clientHeight)&&(L=(0,h.Z)());var W=y.className;if(i.filter(function($){var k,F=$.options;return(F==null?void 0:F.container)===((k=w.options)===null||k===void 0?void 0:k.container)}).length===0&&O.set(y,(0,C.Z)({width:L!==0?"calc(100% - ".concat(L,"px)"):void 0,overflow:"hidden",overflowX:"hidden",overflowY:"hidden"},{element:y})),!f.test(W)){var ne="".concat(W," ").concat(a);y.className=ne.trim()}i=[].concat((0,d.Z)(i),[{target:w.lockTarget,options:w.options}])}},this.unLock=function(){var R,L=i.find(function(ne){var $=ne.target;return $===w.lockTarget});if(i=i.filter(function(ne){var $=ne.target;return $!==w.lockTarget}),!(!L||i.some(function(ne){var $,k=ne.options;return(k==null?void 0:k.container)===(($=L.options)===null||$===void 0?void 0:$.container)}))){var y=((R=w.options)===null||R===void 0?void 0:R.container)||document.body,W=y.className;!f.test(W)||((0,C.Z)(O.get(y),{element:y}),O.delete(y),y.className=y.className.replace(f,"").trim())}},this.lockTarget=v++,this.options=I}},96633:function(ee,S,s){"use strict";s.d(S,{Z:function(){return Ee}});var d=s(6610),x=s(5991),h=s(10379),C=s(44144),i=s(90484),a=s(67294),f=s(75164),v=s(59015),O=s(98924),g=s(74204),P=s(70183);function I(){return document.body.scrollHeight>(window.innerHeight||document.documentElement.clientHeight)&&window.innerWidth>document.body.offsetWidth}var w={},R=function(te){if(!(!I()&&!te)){var U="ant-scrolling-effect",z=new RegExp("".concat(U),"g"),V=document.body.className;if(te){if(!z.test(V))return;(0,P.Z)(w),w={},document.body.className=V.replace(z,"").trim();return}var c=(0,g.Z)();if(c&&(w=(0,P.Z)({position:"relative",width:"calc(100% - ".concat(c,"px)")}),!z.test(V))){var _="".concat(V," ").concat(U);document.body.className=_.trim()}}},L=s(12435),y=0,W=(0,O.Z)();function ne(){return 0}var $={},k=function(U){if(!W)return null;if(U){if(typeof U=="string")return document.querySelectorAll(U)[0];if(typeof U=="function")return U();if((0,i.Z)(U)==="object"&&U instanceof window.HTMLElement)return U}return document.body},F=function(te){(0,h.Z)(z,te);var U=(0,C.Z)(z);function z(V){var c;return(0,d.Z)(this,z),c=U.call(this,V),c.container=void 0,c.componentRef=a.createRef(),c.rafId=void 0,c.scrollLocker=void 0,c.renderComponent=void 0,c.updateScrollLocker=function(_){var E=_||{},G=E.visible,J=c.props,X=J.getContainer,ie=J.visible;ie&&ie!==G&&W&&k(X)!==c.scrollLocker.getContainer()&&c.scrollLocker.reLock({container:k(X)})},c.updateOpenCount=function(_){var E=_||{},G=E.visible,J=E.getContainer,X=c.props,ie=X.visible,se=X.getContainer;ie!==G&&W&&k(se)===document.body&&(ie&&!G?y+=1:_&&(y-=1));var ye=typeof se=="function"&&typeof J=="function";(ye?se.toString()!==J.toString():se!==J)&&c.removeCurrentContainer()},c.attachToParent=function(){var _=arguments.length>0&&arguments[0]!==void 0?arguments[0]:!1;if(_||c.container&&!c.container.parentNode){var E=k(c.props.getContainer);return E?(E.appendChild(c.container),!0):!1}return!0},c.getContainer=function(){return W?(c.container||(c.container=document.createElement("div"),c.attachToParent(!0)),c.setWrapperClassName(),c.container):null},c.setWrapperClassName=function(){var _=c.props.wrapperClassName;c.container&&_&&_!==c.container.className&&(c.container.className=_)},c.removeCurrentContainer=function(){var _,E;(_=c.container)===null||_===void 0||(E=_.parentNode)===null||E===void 0||E.removeChild(c.container)},c.switchScrollingEffect=function(){y===1&&!Object.keys($).length?(R(),$=(0,P.Z)({overflow:"hidden",overflowX:"hidden",overflowY:"hidden"})):y||((0,P.Z)($),$={},R(!0))},c.scrollLocker=new L.Z({container:k(V.getContainer)}),c}return(0,x.Z)(z,[{key:"componentDidMount",value:function(){var c=this;this.updateOpenCount(),this.attachToParent()||(this.rafId=(0,f.Z)(function(){c.forceUpdate()}))}},{key:"componentDidUpdate",value:function(c){this.updateOpenCount(c),this.updateScrollLocker(c),this.setWrapperClassName(),this.attachToParent()}},{key:"componentWillUnmount",value:function(){var c=this.props,_=c.visible,E=c.getContainer;W&&k(E)===document.body&&(y=_&&y?y-1:y),this.removeCurrentContainer(),f.Z.cancel(this.rafId)}},{key:"render",value:function(){var c=this.props,_=c.children,E=c.forceRender,G=c.visible,J=null,X={getOpenCount:function(){return y},getContainer:this.getContainer,switchScrollingEffect:this.switchScrollingEffect,scrollLocker:this.scrollLocker};return(E||G||this.componentRef.current)&&(J=a.createElement(v.Z,{getContainer:this.getContainer,ref:this.componentRef},_(X))),J}}]),z}(a.Component),Ee=F},74204:function(ee,S,s){"use strict";s.d(S,{Z:function(){return x},o:function(){return C}});var d;function x(i){if(typeof document=="undefined")return 0;if(i||d===void 0){var a=document.createElement("div");a.style.width="100%",a.style.height="200px";var f=document.createElement("div"),v=f.style;v.position="absolute",v.top="0",v.left="0",v.pointerEvents="none",v.visibility="hidden",v.width="200px",v.height="150px",v.overflow="hidden",f.appendChild(a),document.body.appendChild(f);var O=a.offsetWidth;f.style.overflow="scroll";var g=a.offsetWidth;O===g&&(g=f.clientWidth),document.body.removeChild(f),d=O-g}return d}function h(i){var a=i.match(/^(.*)px$/),f=Number(a==null?void 0:a[1]);return Number.isNaN(f)?x():f}function C(i){if(typeof document=="undefined"||!i||!(i instanceof Element))return{width:0,height:0};var a=getComputedStyle(i,"::-webkit-scrollbar"),f=a.width,v=a.height;return{width:h(f),height:h(v)}}},70183:function(ee,S){"use strict";function s(d){var x=arguments.length>1&&arguments[1]!==void 0?arguments[1]:{};if(!d)return{};var h=x.element,C=h===void 0?document.body:h,i={},a=Object.keys(d);return a.forEach(function(f){i[f]=C.style[f]}),a.forEach(function(f){C.style[f]=d[f]}),i}S.Z=s},40821:function(ee,S,s){"use strict";s.d(S,{J$:function(){return Ye},ZP:function(){return Fe},JG:function(){return Le},kY:function(){return Ie}});var d=s(67294);function x(e,r,n,o){return new(n||(n=Promise))(function(t,m){function u(T){try{N(o.next(T))}catch(l){m(l)}}function b(T){try{N(o.throw(T))}catch(l){m(l)}}function N(T){var l;T.done?t(T.value):(l=T.value,l instanceof n?l:new n(function(Z){Z(l)})).then(u,b)}N((o=o.apply(e,r||[])).next())})}function h(e,r){var n,o,t,m,u={label:0,sent:function(){if(1&t[0])throw t[1];return t[1]},trys:[],ops:[]};return m={next:b(0),throw:b(1),return:b(2)},typeof Symbol=="function"&&(m[Symbol.iterator]=function(){return this}),m;function b(N){return function(T){return function(l){if(n)throw new TypeError("Generator is already executing.");for(;u;)try{if(n=1,o&&(t=2&l[0]?o.return:l[0]?o.throw||((t=o.return)&&t.call(o),0):o.next)&&!(t=t.call(o,l[1])).done)return t;switch(o=0,t&&(l=[2&l[0],t.value]),l[0]){case 0:case 1:t=l;break;case 4:return u.label++,{value:l[1],done:!1};case 5:u.label++,o=l[1],l=[0];continue;case 7:l=u.ops.pop(),u.trys.pop();continue;default:if(t=u.trys,!((t=t.length>0&&t[t.length-1])||l[0]!==6&&l[0]!==2)){u=0;continue}if(l[0]===3&&(!t||l[1]>t[0]&&l[1]<t[3])){u.label=l[1];break}if(l[0]===6&&u.label<t[1]){u.label=t[1],t=l;break}if(t&&u.label<t[2]){u.label=t[2],u.ops.push(l);break}t[2]&&u.ops.pop(),u.trys.pop();continue}l=r.call(e,u)}catch(Z){l=[6,Z],o=0}finally{n=t=0}if(5&l[0])throw l[1];return{value:l[0]?l[1]:void 0,done:!0}}([N,T])}}}var C,i=function(){},a=i(),f=Object,v=function(e){return e===a},O=function(e){return typeof e=="function"},g=function(e,r){return f.assign({},e,r)},P=typeof window!="undefined",I=typeof document!="undefined",w=new WeakMap,R=0,L=function(e){var r,n,o=typeof e,t=e&&e.constructor,m=t==Date;if(f(e)!==e||m||t==RegExp)r=m?e.toJSON():o=="symbol"?e.toString():o=="string"?JSON.stringify(e):""+e;else{if(r=w.get(e))return r;if(r=++R+"~",w.set(e,r),t==Array){for(r="@",n=0;n<e.length;n++)r+=L(e[n])+",";w.set(e,r)}if(t==f){r="#";for(var u=f.keys(e).sort();!v(n=u.pop());)v(e[n])||(r+=n+":"+L(e[n])+",");w.set(e,r)}}return r},y=!0,W=P?window.addEventListener.bind(window):i,ne=I?document.addEventListener.bind(document):i,$=P&&removeEventListener||i,k=I?document.removeEventListener.bind(document):i,F={isOnline:function(){return y},isVisible:function(){var e=I&&document.visibilityState;return!!v(e)||e!=="hidden"}},Ee={initFocus:function(e){return ne("visibilitychange",e),W("focus",e),function(){k("visibilitychange",e),$("focus",e)}},initReconnect:function(e){var r=function(){y=!0,e()},n=function(){y=!1};return W("online",r),W("offline",n),function(){$("online",r),$("offline",n)}}},te=!P||"Deno"in window,U=P&&window.requestAnimationFrame||function(e){return setTimeout(e,1)},z=te?d.useEffect:d.useLayoutEffect,V=typeof navigator!="undefined"&&navigator.connection,c=!te&&V&&(["slow-2g","2g"].includes(V.effectiveType)||V.saveData),_=function(e){if(O(e))try{e=e()}catch(n){e=""}var r=[].concat(e);return[e=typeof e=="string"?e:(Array.isArray(e)?e.length:e)?L(e):"",r,e?"$err$"+e:"",e?"$req$"+e:""]},E=new WeakMap,G=function(e,r,n,o,t,m){for(var u=E.get(e),b=u[0],N=u[1],T=u[4],l=u[5],Z=b[r],re=N[r]||[],Y=0;Y<re.length;++Y)re[Y](n,o,t);return m&&(delete T[r],delete l[r],Z&&Z[0])?Z[0](2).then(function(){return e.get(r)}):e.get(r)},J=0,X=function(){return++J},ie=function(){for(var e=[],r=0;r<arguments.length;r++)e[r]=arguments[r];return x(void 0,void 0,void 0,function(){var n,o,t,m,u,b,N,T,l,Z,re,Y,de,ve;return h(this,function(ae){switch(ae.label){case 0:if(n=e[0],o=e[1],t=e[3]!==!1,m=e[2],u=_(o),b=u[0],N=u[2],!b)return[2];if(T=E.get(n),l=T[2],Z=T[3],e.length<3)return[2,G(n,b,n.get(b),n.get(N),a,t)];if(de=l[b]=X(),Z[b]=0,O(m))try{m=m(n.get(b))}catch(ce){Y=ce}return m&&O(m.then)?[4,m.catch(function(ce){Y=ce})]:[3,2];case 1:if(re=ae.sent(),de!==l[b]){if(Y)throw Y;return[2,re]}return[3,3];case 2:re=m,ae.label=3;case 3:return Y||n.set(b,re),n.set(N,Y),Z[b]=X(),[4,G(n,b,re,Y,a,t)];case 4:if(ve=ae.sent(),Y)throw Y;return[2,ve]}})})},se=function(e,r){for(var n in e)e[n][0]&&e[n][0](r)},ye=function(e,r){if(!E.has(e)){var n=g(Ee,r),o={},t=ie.bind(a,e),m=i;if(E.set(e,[o,{},{},{},{},{},t]),!te){var u=n.initFocus(se.bind(a,o,0)),b=n.initReconnect(se.bind(a,o,1));m=function(){u&&u(),b&&b(),E.delete(e)}}return[e,t,m]}return[e,E.get(e)[6]]},Ne=ye(new Map),De=Ne[0],Le=Ne[1],Ze=g({onLoadingSlow:i,onSuccess:i,onError:i,onErrorRetry:function(e,r,n,o,t){if(F.isVisible()){var m=n.errorRetryCount,u=t.retryCount,b=~~((Math.random()+.5)*(1<<(u<8?u:8)))*n.errorRetryInterval;!v(m)&&u>m||setTimeout(o,b,t)}},onDiscarded:i,revalidateOnFocus:!0,revalidateOnReconnect:!0,revalidateIfStale:!0,shouldRetryOnError:!0,errorRetryInterval:c?1e4:5e3,focusThrottleInterval:5e3,dedupingInterval:2e3,loadingTimeout:c?5e3:3e3,compare:function(e,r){return L(e)==L(r)},isPaused:function(){return!1},cache:De,mutate:Le,fallback:{}},F),Me=function(e,r){var n=g(e,r);if(r){var o=e.use,t=e.fallback,m=r.use,u=r.fallback;o&&m&&(n.use=o.concat(m)),t&&u&&(n.fallback=g(t,u))}return n},$e=(0,d.createContext)({}),Ve=function(e){return O(e[1])?[e[0],e[1],e[2]||{}]:[e[0],null,(e[1]===null?e[2]:e[1])||{}]},Ie=function(){return g(Ze,(0,d.useContext)($e))},We=function(e,r,n){var o=r[e]||(r[e]=[]);return o.push(n),function(){var t=o.indexOf(n);t>=0&&(o[t]=o[o.length-1],o.pop())}},ke={dedupe:!0},Ye=f.defineProperty(function(e){var r=e.value,n=Me((0,d.useContext)($e),r),o=r&&r.provider,t=(0,d.useState)(function(){return o?ye(o(n.cache||De),r):a})[0];return t&&(n.cache=t[0],n.mutate=t[1]),z(function(){return t?t[2]:a},[]),(0,d.createElement)($e.Provider,g(e,{value:n}))},"default",{value:Ze}),Ke=function(e){return _(e)[0]},Fe=(C=function(e,r,n){var o=n.cache,t=n.compare,m=n.fallbackData,u=n.suspense,b=n.revalidateOnMount,N=n.refreshInterval,T=n.refreshWhenHidden,l=n.refreshWhenOffline,Z=E.get(o),re=Z[0],Y=Z[1],de=Z[2],ve=Z[3],ae=Z[4],ce=Z[5],Ce=_(e),p=Ce[0],Be=Ce[1],Te=Ce[2],xe=Ce[3],we=(0,d.useRef)(!1),pe=(0,d.useRef)(!1),Pe=(0,d.useRef)(p),Ae=(0,d.useRef)(n),A=function(){return Ae.current},Ue=o.get(p),He=v(m)?n.fallback[p]:m,le=v(Ue)?He:Ue,me=o.get(Te),ze=function(){return v(b)?!A().isPaused()&&(u?!v(le):v(le)||n.revalidateIfStale):b},Se=!(!p||!r)&&(!!o.get(xe)||!we.current&&ze()),Oe=function(B,M){var H=(0,d.useState)({})[1],oe=(0,d.useRef)(B),ue=(0,d.useRef)({data:!1,error:!1,isValidating:!1}),j=(0,d.useCallback)(function(D){var Q=!1,K=oe.current;for(var ge in D){var q=ge;K[q]!==D[q]&&(K[q]=D[q],ue.current[q]&&(Q=!0))}Q&&!M.current&&H({})},[]);return z(function(){oe.current=B}),[oe,ue.current,j]}({data:le,error:me,isValidating:Se},pe),he=Oe[0],Re=Oe[1],_e=Oe[2],fe=(0,d.useCallback)(function(B){return x(void 0,void 0,void 0,function(){var M,H,oe,ue,j,D,Q,K,ge,q;return h(this,function(be){switch(be.label){case 0:if(!p||!r||pe.current||A().isPaused())return[2,!1];oe=!0,ue=B||{},j=v(ae[p])||!ue.dedupe,D=function(){return!pe.current&&p===Pe.current&&we.current},Q=function(){ce[p]===H&&(delete ae[p],delete ce[p])},K={isValidating:!1},ge=function(){o.set(xe,!1),D()&&_e(K)},o.set(xe,!0),_e({isValidating:!0}),be.label=1;case 1:return be.trys.push([1,3,,4]),j&&(G(o,p,he.current.data,he.current.error,!0),n.loadingTimeout&&!o.get(p)&&setTimeout(function(){oe&&D()&&A().onLoadingSlow(p,n)},n.loadingTimeout),ce[p]=X(),ae[p]=r.apply(void 0,Be)),H=ce[p],[4,ae[p]];case 2:return M=be.sent(),j&&setTimeout(Q,n.dedupingInterval),ce[p]!==H?(j&&D()&&A().onDiscarded(p),[2,!1]):(o.set(Te,a),K.error=a,!v(de[p])&&(H<=de[p]||H<=ve[p]||ve[p]===0)?(ge(),j&&D()&&A().onDiscarded(p),[2,!1]):(t(he.current.data,M)||(K.data=M),t(o.get(p),M)||o.set(p,M),j&&D()&&A().onSuccess(M,p,n),[3,4]));case 3:return q=be.sent(),Q(),A().isPaused()||(o.set(Te,q),K.error=q,j&&D()&&(A().onError(q,p,n),n.shouldRetryOnError&&A().onErrorRetry(q,p,n,fe,{retryCount:(ue.retryCount||0)+1,dedupe:!0}))),[3,4];case 4:return oe=!1,ge(),D()&&j&&G(o,p,K.data,K.error,!1),[2,!0]}})})},[p]),je=(0,d.useCallback)(ie.bind(a,o,function(){return Pe.current}),[]);if(z(function(){Ae.current=n}),z(function(){if(p){var B=we.current,M=fe.bind(a,ke),H=function(){return A().isVisible()&&A().isOnline()},oe=0,ue=We(p,Y,function(D,Q,K){_e(g({error:Q,isValidating:K},t(he.current.data,D)?a:{data:D}))}),j=We(p,re,function(D){if(D==0){var Q=Date.now();A().revalidateOnFocus&&Q>oe&&H()&&(oe=Q+A().focusThrottleInterval,M())}else if(D==1)A().revalidateOnReconnect&&H()&&M();else if(D==2)return fe()});return pe.current=!1,Pe.current=p,we.current=!0,B&&_e({data:le,error:me,isValidating:Se}),ze()&&(v(le)||te?M():U(M)),function(){pe.current=!0,ue(),j()}}},[p,fe]),z(function(){var B;function M(){N&&B!==-1&&(B=setTimeout(H,N))}function H(){he.current.error||!T&&!A().isVisible()||!l&&!A().isOnline()?M():fe(ke).then(M)}return M(),function(){B&&(clearTimeout(B),B=-1)}},[N,T,l,fe]),(0,d.useDebugValue)(le),u&&v(le))throw v(me)?fe(ke):me;return{mutate:je,get data(){return Re.data=!0,le},get error(){return Re.error=!0,me},get isValidating(){return Re.isValidating=!0,Se}}},function(){for(var e=[],r=0;r<arguments.length;r++)e[r]=arguments[r];var n=Ie(),o=Ve(e),t=o[0],m=o[1],u=o[2],b=Me(n,u),N=C,T=b.use;if(T)for(var l=T.length;l-- >0;)N=T[l](N);return N(t,m||b.fetcher,b)})},42473:function(ee){"use strict";var S=!1,s=function(){};if(S){var d=function(h,C){var i=arguments.length;C=new Array(i>1?i-1:0);for(var a=1;a<i;a++)C[a-1]=arguments[a];var f=0,v="Warning: "+h.replace(/%s/g,function(){return C[f++]});typeof console!="undefined"&&console.error(v);try{throw new Error(v)}catch(O){}};s=function(x,h,C){var i=arguments.length;C=new Array(i>2?i-2:0);for(var a=2;a<i;a++)C[a-2]=arguments[a];if(h===void 0)throw new Error("`warning(condition, format, ...args)` requires a warning message argument");x||d.apply(null,[h].concat(C))}}ee.exports=s}}]);