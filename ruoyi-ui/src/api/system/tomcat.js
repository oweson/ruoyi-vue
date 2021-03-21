import request from '@/utils/request'

// 查询测试列表
export function listTomcat(query) {
  return request({
    url: '/system/tomcat/list',
    method: 'get',
    params: query
  })
}

// 查询测试详细
export function getTomcat(id) {
  return request({
    url: '/system/tomcat/' + id,
    method: 'get'
  })
}

// 新增测试
export function addTomcat(data) {
  return request({
    url: '/system/tomcat',
    method: 'post',
    data: data
  })
}

// 修改测试
export function updateTomcat(data) {
  return request({
    url: '/system/tomcat',
    method: 'put',
    data: data
  })
}

// 删除测试
export function delTomcat(id) {
  return request({
    url: '/system/tomcat/' + id,
    method: 'delete'
  })
}

// 导出测试
export function exportTomcat(query) {
  return request({
    url: '/system/tomcat/export',
    method: 'get',
    params: query
  })
}