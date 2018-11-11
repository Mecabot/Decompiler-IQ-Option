package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.f.d;
import kotlin.f.f;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\"\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010$\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010$\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010'\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010(\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0002H\b\u001a \u0010*\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u0010+\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010,\u001a\u00020-*\u00020\u0002H\u0002\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010/\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010/\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00100\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u0002\u001a\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u0002\u001a\u0015\u00104\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u00105\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00106\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001aG\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010?\u001a=\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u0006\u0010;\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0002\b>\u001a4\u0010@\u001a\u00020\r*\u00020\u00022\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u0002\u001a\u0012\u0010C\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u0002\u001a\u001a\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\b\u001a\u0015\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001H\b\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010G\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u00020LH\b\u001a\u001d\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\b\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001d\u0010T\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\b\u001a\"\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002\u001a\u001a\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002\u001a%\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002H\b\u001a\u001d\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002H\b\u001a=\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006¢\u0006\u0002\u0010W\u001a0\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a/\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010I\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0002\bX\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010=\u001a\u00020\u0006H\b\u001a=\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006¢\u0006\u0002\u0010Z\u001a0\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010\\\u001a\u00020\u0002*\u00020\n2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0006H\b\u001a\u001f\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006H\b\u001a\u0012\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010_\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\n\u0010d\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010d\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010d\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010d\u001a\u00020\n*\u00020\nH\b\u001a!\u0010d\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010d\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010f\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010f\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010f\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010f\u001a\u00020\n*\u00020\nH\b\u001a!\u0010f\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010f\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010g\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010g\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010g\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010g\u001a\u00020\n*\u00020\nH\b\u001a!\u0010g\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010g\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006h"}, aXE = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"})
/* compiled from: Strings.kt */
class v extends u {
    public static final f N(CharSequence charSequence) {
        h.e(charSequence, "$receiver");
        return new f(0, charSequence.length() - 1);
    }

    public static final int O(CharSequence charSequence) {
        h.e(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static final String a(String str, f fVar) {
        h.e(str, "$receiver");
        h.e(fVar, "range");
        str = str.substring(fVar.aYj().intValue(), fVar.aYk().intValue() + 1);
        h.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str;
    }

    public static final String a(CharSequence charSequence, f fVar) {
        h.e(charSequence, "$receiver");
        h.e(fVar, "range");
        return charSequence.subSequence(fVar.aYj().intValue(), fVar.aYk().intValue() + 1).toString();
    }

    public static final String a(String str, char c, String str2) {
        h.e(str, "$receiver");
        h.e(str2, "missingDelimiterValue");
        int a = a((CharSequence) str, c, 0, false, 6, null);
        if (a == -1) {
            return str2;
        }
        str2 = str.substring(0, a);
        h.d(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str2;
    }

    public static final String m(String str, String str2, String str3) {
        h.e(str, "$receiver");
        h.e(str2, "delimiter");
        h.e(str3, "missingDelimiterValue");
        int a = a((CharSequence) str, str2, 0, false, 6, null);
        if (a == -1) {
            return str3;
        }
        str3 = str.substring(0, a);
        h.d(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str3;
    }

    public static final String b(String str, char c, String str2) {
        h.e(str, "$receiver");
        h.e(str2, "missingDelimiterValue");
        int a = a((CharSequence) str, c, 0, false, 6, null);
        if (a == -1) {
            return str2;
        }
        str2 = str.substring(a + 1, str.length());
        h.d(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str2;
    }

    public static final String n(String str, String str2, String str3) {
        h.e(str, "$receiver");
        h.e(str2, "delimiter");
        h.e(str3, "missingDelimiterValue");
        int a = a((CharSequence) str, str2, 0, false, 6, null);
        if (a == -1) {
            return str3;
        }
        str3 = str.substring(a + str2.length(), str.length());
        h.d(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str3;
    }

    public static final String c(String str, char c, String str2) {
        h.e(str, "$receiver");
        h.e(str2, "missingDelimiterValue");
        int b = b((CharSequence) str, c, 0, false, 6, null);
        if (b == -1) {
            return str2;
        }
        str2 = str.substring(0, b);
        h.d(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str2;
    }

    public static final String o(String str, String str2, String str3) {
        h.e(str, "$receiver");
        h.e(str2, "delimiter");
        h.e(str3, "missingDelimiterValue");
        int b = b((CharSequence) str, str2, 0, false, 6, null);
        if (b == -1) {
            return str3;
        }
        str3 = str.substring(0, b);
        h.d(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str3;
    }

    public static final String d(String str, char c, String str2) {
        h.e(str, "$receiver");
        h.e(str2, "missingDelimiterValue");
        int b = b((CharSequence) str, c, 0, false, 6, null);
        if (b == -1) {
            return str2;
        }
        str2 = str.substring(b + 1, str.length());
        h.d(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str2;
    }

    public static final String p(String str, String str2, String str3) {
        h.e(str, "$receiver");
        h.e(str2, "delimiter");
        h.e(str3, "missingDelimiterValue");
        int b = b((CharSequence) str, str2, 0, false, 6, null);
        if (b == -1) {
            return str3;
        }
        str3 = str.substring(b + str2.length(), str.length());
        h.d(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return str3;
    }

    public static final String a(String str, CharSequence charSequence) {
        h.e(str, "$receiver");
        h.e(charSequence, "prefix");
        if (!a((CharSequence) str, charSequence, false, 2, null)) {
            return str;
        }
        str = str.substring(charSequence.length());
        h.d(str, "(this as java.lang.String).substring(startIndex)");
        return str;
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!c.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(CharSequence charSequence, char c, boolean z) {
        h.e(charSequence, "$receiver");
        return charSequence.length() > 0 && c.a(charSequence.charAt(0), c, z);
    }

    public static final boolean b(CharSequence charSequence, char c, boolean z) {
        h.e(charSequence, "$receiver");
        return charSequence.length() > 0 && c.a(charSequence.charAt(O(charSequence)), c, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return u.a((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return a(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(i.a(cArr), i);
        }
        i = j.be(i, 0);
        int O = O(charSequence);
        if (i <= O) {
            while (true) {
                Object obj;
                char charAt = charSequence.charAt(i);
                for (char a : cArr) {
                    if (c.a(a, charAt, z)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    if (i == O) {
                        break;
                    }
                    i++;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

    public static final int b(CharSequence charSequence, char[] cArr, int i, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(i.a(cArr), i);
        }
        for (i = j.bf(i, O(charSequence)); i >= 0; i--) {
            char charAt = charSequence.charAt(i);
            Object obj = null;
            for (char a : cArr) {
                if (c.a(a, charAt, z)) {
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                return i;
            }
        }
        return -1;
    }

    static /* bridge */ /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        d bc;
        if (z2) {
            bc = j.bc(j.bf(i, O(charSequence)), j.be(i2, 0));
        } else {
            bc = new f(j.be(i, 0), j.bf(i2, charSequence.length()));
        }
        int aYh;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            i = bc.getFirst();
            i2 = bc.getLast();
            aYh = bc.aYh();
            if (aYh <= 0 ? i < i2 : i > i2) {
                while (true) {
                    if (!u.a((String) charSequence2, 0, (String) charSequence, i, charSequence2.length(), z)) {
                        if (i == i2) {
                            break;
                        }
                        i += aYh;
                    } else {
                        return i;
                    }
                }
            }
        } else {
            i = bc.getFirst();
            i2 = bc.getLast();
            aYh = bc.aYh();
            if (aYh <= 0 ? i < i2 : i > i2) {
                while (true) {
                    if (!a(charSequence2, 0, charSequence, i, charSequence2.length(), z)) {
                        if (i == i2) {
                            break;
                        }
                        i += aYh;
                    } else {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private static final Pair<Integer, String> a(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Pair<Integer, String> pair = null;
        if (z || collection.size() != 1) {
            d fVar = !z2 ? new f(j.be(i, 0), charSequence.length()) : j.bc(j.bf(i, O(charSequence)), 0);
            int last;
            int aYh;
            String str;
            Object obj;
            String str2;
            if (charSequence instanceof String) {
                i = fVar.getFirst();
                last = fVar.getLast();
                aYh = fVar.aYh();
                if (aYh <= 0 ? i < last : i > last) {
                    while (true) {
                        for (Object obj2 : collection) {
                            str = (String) obj2;
                            if (u.a(str, 0, (String) charSequence, i, str.length(), z)) {
                                break;
                            }
                        }
                        obj2 = null;
                        str2 = (String) obj2;
                        if (str2 == null) {
                            if (i == last) {
                                break;
                            }
                            i += aYh;
                        } else {
                            return j.D(Integer.valueOf(i), str2);
                        }
                    }
                }
            } else {
                i = fVar.getFirst();
                last = fVar.getLast();
                aYh = fVar.aYh();
                if (aYh <= 0 ? i < last : i > last) {
                    while (true) {
                        for (Object obj22 : collection) {
                            str = (String) obj22;
                            if (a((CharSequence) str, 0, charSequence, i, str.length(), z)) {
                                break;
                            }
                        }
                        obj22 = null;
                        str2 = (String) obj22;
                        if (str2 == null) {
                            if (i == last) {
                                break;
                            }
                            i += aYh;
                        } else {
                            return j.D(Integer.valueOf(i), str2);
                        }
                    }
                }
            }
            return null;
        }
        String str3 = (String) u.Q(collection);
        int a = !z2 ? a(charSequence, str3, i, false, 4, null) : b(charSequence, str3, i, false, 4, null);
        if (a >= 0) {
            pair = j.D(Integer.valueOf(a), str3);
        }
        return pair;
    }

    public static final int a(CharSequence charSequence, char c, int i, boolean z) {
        h.e(charSequence, "$receiver");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return a(charSequence, new char[]{c}, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static final int b(CharSequence charSequence, char c, int i, boolean z) {
        h.e(charSequence, "$receiver");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return b(charSequence, new char[]{c}, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    public static final boolean b(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        h.e(charSequence, "$receiver");
        h.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z, 2, null) < 0) {
                return false;
            }
        }
        if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static final boolean c(CharSequence charSequence, char c, boolean z) {
        h.e(charSequence, "$receiver");
        return a(charSequence, c, 0, z, 2, null) >= 0;
    }

    private static final kotlin.sequences.h<f> a(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        if ((i2 >= 0 ? 1 : null) != null) {
            return new e(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Limit must be non-negative, but was ");
        stringBuilder.append(i2);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    private static final kotlin.sequences.h<f> a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if ((i2 >= 0 ? 1 : null) != null) {
            return new e(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(h.asList(strArr), z));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Limit must be non-negative, but was ");
        stringBuilder.append(i2);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public static final kotlin.sequences.h<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        h.e(charSequence, "$receiver");
        h.e(strArr, "delimiters");
        return m.f(a(charSequence, strArr, 0, z, i, 2, null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static final List<String> b(CharSequence charSequence, String[] strArr, boolean z, int i) {
        h.e(charSequence, "$receiver");
        h.e(strArr, "delimiters");
        if (strArr.length == 1) {
            int i2 = 0;
            String str = strArr[0];
            if (str.length() == 0) {
                i2 = 1;
            }
            if (i2 == 0) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable<f> j = m.j(a(charSequence, strArr, 0, z, i, 2, null));
        Collection arrayList = new ArrayList(n.e(j, 10));
        for (f a : j) {
            arrayList.add(a(charSequence, a));
        }
        return (List) arrayList;
    }

    public static final kotlin.sequences.h<String> a(CharSequence charSequence, char[] cArr, boolean z, int i) {
        h.e(charSequence, "$receiver");
        h.e(cArr, "delimiters");
        return m.f(a(charSequence, cArr, 0, z, i, 2, null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    public static final List<String> b(CharSequence charSequence, char[] cArr, boolean z, int i) {
        h.e(charSequence, "$receiver");
        h.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return a(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<f> j = m.j(a(charSequence, cArr, 0, z, i, 2, null));
        Collection arrayList = new ArrayList(n.e(j, 10));
        for (f a : j) {
            arrayList.add(a(charSequence, a));
        }
        return (List) arrayList;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if ((i >= 0 ? 1 : null) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Limit must be non-negative, but was ");
            stringBuilder.append(i);
            stringBuilder.append('.');
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        int a = a(charSequence, str, 0, z);
        if (a == -1 || i == 1) {
            return l.cr(charSequence.toString());
        }
        Object obj = i > 0 ? 1 : null;
        int i3 = 10;
        if (obj != null) {
            i3 = j.bf(i, 10);
        }
        ArrayList arrayList = new ArrayList(i3);
        do {
            arrayList.add(charSequence.subSequence(i2, a).toString());
            i2 = str.length() + a;
            if (obj != null && arrayList.size() == i - 1) {
                break;
            }
            a = a(charSequence, str, i2, z);
        } while (a != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        h.e(charSequence, "$receiver");
        int length = charSequence.length() - 1;
        int i = 0;
        Object obj = null;
        while (i <= length) {
            boolean isWhitespace = b.isWhitespace(charSequence.charAt(obj == null ? i : length));
            if (obj == null) {
                if (isWhitespace) {
                    i++;
                } else {
                    obj = 1;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }
}
