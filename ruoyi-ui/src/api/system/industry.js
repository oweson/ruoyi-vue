import request from '@/utils/request'

// 查询行业列表
export function listIndustry(query) {
  return request({
    url: '/system/industry/list',
    method: 'get',
    params: query
  })
}

// 查询行业详细
export function getIndustry(code) {
  return request({
    url: '/system/industry/' + code,
    method: 'get'
  })
}

// 新增行业
export function addIndustry(data) {
  return request({
    url: '/system/industry',
    method: 'post',
    data: data
  })
}

// 修改行业
export function updateIndustry(data) {
  return request({
    url: '/system/industry',
    method: 'put',
    data: data
  })
}

// 删除行业
export function delIndustry(code) {
  return request({
    url: '/system/industry/' + code,
    method: 'delete'
  })
}
