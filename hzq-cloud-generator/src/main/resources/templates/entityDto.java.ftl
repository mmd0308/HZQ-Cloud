package ${package.Entity};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#if swagger2>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Data
    <#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
    <#else>
@EqualsAndHashCode(callSuper = false)
    </#if>
@Accessors(chain = true)
</#if>
<#if table.convert>
@TableName("${table.name}")
</#if>
public class ${entity} extends ${superEntityClass} {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

    <#-- 主键 -->
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

    <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
    </#if>
    <#-- 普通字段 -->
    <#if field.convert>
    @TableField("${field.name}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->

}
